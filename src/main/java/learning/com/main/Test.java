package learning.com.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

/**
 * Create by HuQiuYue on 2020/1/8
 */
public class Test {

    public static String sign(String appKey, long timestamp, String appSecret) {
        String signStr = new StringBuilder()
                .append(appKey)
                .append(":")
                .append(timestamp)
                .append(":")
                .append(appSecret).toString();
        //获取MD5加密后的字符串
        String sign = parseStrToMd5L32(signStr);
        return sign;
    }

    public static String parseStrToMd5L32(String str) {
        String reStr = null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[0];
        try {
            bytes = md5.digest(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            int bt = b & 0xff;
            if (bt < 16) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(bt));
        }
        reStr = sb.toString();
        return reStr;
    }

    public static  String getImageDataFromUrl() throws IOException {
        String imageUrl = "http://download.maycur.com/invoice-identify/maycur-sample.jpg";
        URL url = new URL(imageUrl);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            data.write(buffer, 0, len);
        }
        is.close();

        return Base64.encodeBase64String(data.toByteArray());
    }


    public static void main(String[] args) throws IOException {
        Long time = System.currentTimeMillis();
        System.out.println(time + "    "   + sign("7ae639ce60275357",time,"c1fd40970143459aa86da4f86dcf0eb7"));
//        System.out.println(getImageDataFromUrl());
    }
}
