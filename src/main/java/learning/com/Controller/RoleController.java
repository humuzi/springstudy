package learning.com.Controller;

import learning.com.pojo.Role;
import learning.com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-10-25
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired private RoleService roleService = null;

    @GetMapping(value = "/getRole")
    public ModelAndView getRole(@RequestParam("userName") String userName){
        Role role = roleService.selectOne(userName);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");

//        给数据模型添加一个角色对象
        mv.addObject("role",role);

        return mv;

    }

    @GetMapping(value = "getRole/{userName}")
    public ModelAndView getRoleRestfulUrl(@PathVariable("userName") String userName){
        Role role = roleService.selectOne(userName);
        ModelAndView mv = new ModelAndView();
        mv.addObject(role);
        mv.setViewName("roleDetail");
        return mv;
    }
//
//    @GetMapping(value = "getRoles")
//    public ModelAndView getRoles(@RequestBody Role role){
//        List<Role> roleList = roleService.selectRoles(role);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject(roleList);
//        return mv;
//    }


//    @DeleteMapping("/deleteRoles")
//    public ModelAndView deleteRoles(@RequestBody List<String> userNameList){
//
//    }

}
