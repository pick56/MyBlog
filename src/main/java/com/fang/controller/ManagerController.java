package com.fang.controller;

import com.fang.model.User;
import com.fang.service.ManagerService;
import net.sf.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


import net.sf.json.JSONArray;


@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService ;

    @RequestMapping("/show")
    public String showAllUser(HttpServletRequest request,String id){
        System.out.println("id="+id);
        ArrayList<User> userlist = managerService.getAllUser() ;
        JSONObject ret = new JSONObject() ;
        JSONArray retlist = JSONArray.fromObject(userlist) ;
        System.out.println(retlist);
        return retlist.toString() ;
    }
}
