package learning.com.main;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Create by HuQiuYue on 2019-12-02
 */
public class TestDemo {

    public static void main(String[] args) {
        String platformCode = "huoliflight";
        String platformSecret = "VdLIyWIzEYF4At2T1x7reIm5e0POmfvshQR9FHJj5FawHHDCAmHFbb5wabwjTgbS"; //huoliflight dev
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String signature = DigestUtils.sha256Hex(platformSecret + ":" + platformCode + ":" + timestamp);
        System.out.println(signature);
    }
}
