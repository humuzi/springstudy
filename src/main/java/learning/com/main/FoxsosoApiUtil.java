package learning.com.main;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by HuQiuYue on 2020/1/14
 */
public class FoxsosoApiUtil {
    private String sendTimeString;  // HTTP 请求头中的 SendTime 字段
    private String data;            // HTTP 请求正文 (加密前)
    private String sign;            // headers 中的 Sign 字段
    private String partnerId;       // headers 中的 PartnerId 字段
    private String partnerKey;      // 加密需要使用的密钥

    public FoxsosoApiUtil(String data, String partnerId, String partnerKey) {
        sendTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.data = data;
        this.partnerId = partnerId;
        this.partnerKey = partnerKey;
        this.generateSign();
    }

    public String getData() {
        return data;
    }

    /**
     * Sign = Post 的原文 + SendTime + PartnerKey 连接成一个字符串，做 MD5
     */
    private void generateSign() {
        this.sign = Md5Util.encodeByMd5(data + sendTimeString + partnerKey);
    }

    /**
     * HTTP 请求体需要 DES 加密以及 Base64 编码
     *
     * @return 经过 DES 加密和 Base64 编码之后的字符串
     */
    public String generateHttpBody() {
        return DesUtil.desEncryption(data, partnerKey);
    }

    /**
     * 生成符合 Foxsoso API 要求的请求头
     * @return 请求头
     * */
    public Map<String, String> generateHttpHeaders() {
        return HttpUtil.headersGenerator(this.sendTimeString, this.sign, this.partnerId);
    }

    public static void main(String[] args) {
        String jsonString = "{\n" +
//                "    \"TaNos\":[\n" +
//                "\n" +
//                "    ],\n" +
//                "    \"UserName\":\"190096\",\n" +
                "    \"StartTravelTime\":\"20200107163916\",\n" +
                "    \"EndTravelTime\":\"20200115163916\"\n" +
                "}";


        FoxsosoApiUtil foxsosoApiUtil = new FoxsosoApiUtil(jsonString,
                "meike-EC1705101O7ZQCCG", "kp7idvga");

        Map<String, String> headers = foxsosoApiUtil.generateHttpHeaders();
        for (String key: headers.keySet()) {
            System.out.println(key + ": " + headers.get(key));
        }

        System.out.println(foxsosoApiUtil.generateHttpBody());
    }

}
class Md5Util {

    private static MessageDigest MD5;


    static {
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * MD5 散列
     *
     * @param text 需要散列的字符串
     * @return 返回 MD5 散列完成的字符串
     */
    public static String encodeByMd5(String text) {
        byte[] md5Bytes = MD5.digest(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder md5StringBuilder = new StringBuilder();
        for (byte b: md5Bytes) {
            String temp = Integer.toHexString(b & 0xff);
            if(temp.length() == 1) temp = "0" + temp;
            md5StringBuilder.append(temp);
        }

        return md5StringBuilder.toString().toUpperCase();
    }
}

class  HttpUtil{
    public static Map<String, String> headersGenerator(String sendTime, String sign, String partnerId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("SendTime", sendTime);
        headers.put("Sign", sign);
        headers.put("PartnerId", partnerId);
        return headers;
    }
}

class DesUtil {
    private static final Logger logger = LoggerFactory.getLogger(SHAUtil.class);

    /**
     * 生成 DES 密钥
     *
     * @param desKey 密钥明文
     * @return DES 密钥
     */
    private static SecretKey generateKey(String desKey) {
        return new SecretKeySpec(desKey.getBytes(), "DES");
    }

    /**
     * DES 加密
     *
     * @param content 待加密的文本
     * @return 经过 DES 加密后 Base64 编码后的字符串
     */
    public static String desEncryption(String content, String desKey) {
        SecretKey secretKey = generateKey(desKey);
        byte[] resultBytes = {};

        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            resultBytes = cipher.doFinal(content.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | BadPaddingException | IllegalBlockSizeException e) {
            logger.error("Fail to encrypt {} with algorithm {}: {}", content, "DES", e.getMessage());
        }

        return Base64.getEncoder().encodeToString(resultBytes);
    }

    /**
     * DES 解密
     *
     * @param content 待解密的密文字符串 (Base64 编码)
     * @return 经过解密后的字符串
     */
    public static String desDecryption(String content, String desKey) {
        SecretKey secretKey = generateKey(desKey);
        byte[] resultBytes = {};

        byte[] tempBytes = Base64.getDecoder().decode(content.getBytes());

        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            resultBytes = cipher.doFinal(tempBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return new String(resultBytes);
    }
}

class SHAUtil {
    private static final Logger logger = LoggerFactory.getLogger(SHAUtil.class);
    /***
     *  利用Apache的工具类实现SHA-256加密
     * @param plainText 加密后的报文
     * @return
     */
    public static String encodeBy256(String plainText){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(plainText.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hash);
        } catch (Exception e) {
            logger.error("fail to encode {} due to : {}", plainText, e.getMessage());
            return null;
        }

    }
}
