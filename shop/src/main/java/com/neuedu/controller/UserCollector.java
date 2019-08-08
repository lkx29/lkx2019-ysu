package com.neuedu.controller;


import com.neuedu.consts.Const;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

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


    @RequestMapping("find")
    public String findAll(HttpSession session){
        List<UserInfo> userInfolist =userService.findAll();
        System.out.println();
        session.setAttribute("userInfolist",userInfolist);
        return "userinfolist";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id")Integer userInfoId, HttpServletRequest request) {

        UserInfo userInfo= userService.findById(userInfoId);

        request.setAttribute("userInfo", userInfo);


        return "userinfoupdate";

    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        int count=userService.updateUserInfo(userInfo);
        if (count>0){
            return "redirect:/user/find";
        }
        return "userinfoupdate";


    }
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(HttpSession session){

        return "userinfoadd";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        int count =userService.addUserInfo(userInfo);
        if (count>0){
            return "redirect:/user/find";
        }
        return "userinfoadd";
    }@RequestMapping("delete/{id}")
    public String delete(UserInfo userInfo){
        int userInfoId=userInfo.getId();
        int count=userService.deleteUserInfo(userInfoId);
        return "redirect:/user/find";
    }
}
