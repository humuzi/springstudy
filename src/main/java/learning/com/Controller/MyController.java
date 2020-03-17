package learning.com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by HuQiuYue on 2019-10-24
 */
@Controller
@RequestMapping("/my")
public class MyController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/requestParam")
    public ModelAndView requestParam(@RequestParam("role_name")String roleName,String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
