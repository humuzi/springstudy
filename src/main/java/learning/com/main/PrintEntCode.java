package learning.com.main;

import learning.com.service.EntCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by HuQiuYue on 2020/3/13
 */
public class PrintEntCode {
     @Autowired private  static EntCodeService entCodeService;


    static  List  entCode = new ArrayList();








    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");

        entCodeService = applicationContext.getBean(EntCodeService.class);



        System.out.println(entCodeService.getEntCode());
    }

}
