package com.casic.warehouse.controller;

import com.casic.warehouse.bean.User;
import com.casic.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/user/login";
    }

    /**
     * 验证用户名和密码的方法并且跳转到指定页面
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/loginCheck")
    public String login(@RequestParam("username")String username, @RequestParam("password") String password, HttpSession session){
        System.out.println(username+"  "+password);
        User user=userService.getUserByLoginName(username);
        if(user==null){
            session .setAttribute("msg","用户不存在");
            return "views/user/login";
        }
        if(!password.equals(user.getPwd())){
            session.setAttribute("msg","密码错误");
            return "views/user/login";
        }
        session.setAttribute("user",user);
        return "redirect:/toIndex";
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        System.out.println("==============");
        //使当前登录人的session失效
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping("/")
    public String login(){
        System.out.println("登录页面跳转");
        return "views/user/login";
    }
    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "views/test";
    }
}
