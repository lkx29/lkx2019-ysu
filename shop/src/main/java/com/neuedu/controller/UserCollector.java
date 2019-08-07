package com.neuedu.controller;


import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/user/")
public class UserCollector {

    @Autowired
    IUserService userService;

@RequestMapping(value = "/login",method = RequestMethod.GET)
public  String login(){
    return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpSession session,
                         HttpServletResponse response){


        UserInfo loginuserInfo =userService.login(userInfo);
        System.out.println(loginuserInfo);
        if (loginuserInfo!=null){
            session.setAttribute(Const.CURRENT_USER, loginuserInfo);

            Cookie usernamecookie=new Cookie("username",loginuserInfo.getUsername());
            Cookie passwordcookie=new Cookie("password",loginuserInfo.getPassword());
            usernamecookie.setMaxAge(60*60*7*24);
            passwordcookie.setMaxAge(60*60*7*24);

            response.addCookie(usernamecookie);
            response.addCookie(passwordcookie);
            return "redirect:home";
        }
    return "login";
    }

    @RequestMapping("home")
    public String home(){
            return "home";
    }
}
