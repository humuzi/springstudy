package learning.com.main;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * Create by HuQiuYue on 2020/2/13
 */
public class Test3 {
    public static void main(String[] args) {
        String appSecret = "123456";
        long timestamp = System.currentTimeMillis();
        String appCode = "Disi001";
        String secret = DigestUtils.sha256Hex((appSecret + ":" + appCode + ":" + timestamp));
        System.out.println(timestamp + "    " + secret);
    }
}
