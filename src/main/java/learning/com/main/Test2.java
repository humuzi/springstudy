package learning.com.main;

import sun.security.provider.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by HuQiuYue on 2020/1/12
 */
public class Test2 {
    public String sign(String companyId, String sendTime, String password){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        sendTime = df.format(new Date());
        return  sendTime;

    }
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSS");
        System.out.println(df.format(new Date()));

    }
}
