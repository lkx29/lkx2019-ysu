package com.neuedu.controller;


import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IManagerService;
import com.neuedu.service.Impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/manager/")
public class ManagerController {


    @Autowired
    IManagerService managerService;
    @RequestMapping("find")
    public String findAll(HttpSession session){
        List<UserInfo> managerlist=managerService.findAll();
        session.setAttribute("managerlist",managerlist);

        return "managerlist";



    }
}
