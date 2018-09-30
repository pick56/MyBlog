package com.fang.controller;

import com.fang.model.User;
import com.fang.service.ManagerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mgr")
public class ManagerController {
    @Resource
    private ManagerService managerService ;

    @ResponseBody
    @RequestMapping("/show")
    public String showAllUser(HttpServletRequest request,HttpServletResponse response){
//        System.out.println("username3="+username);
//        System.out.println("password3="+password);
        String xx = request.getParameter("username") ;
        System.out.println(xx);
        ArrayList<User> userlist = managerService.getAllUser() ;
        JSONArray retlist = JSONArray.fromObject(userlist) ;
        System.out.println(retlist);
        return retlist.toString();
    }
}
