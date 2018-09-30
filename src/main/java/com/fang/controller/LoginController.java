package com.fang.controller;

import com.fang.service.ManagerService;
import com.fang.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fang.model.User;
import com.fang.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    /**
     * 登录页面
     */
    @RequestMapping("/index")
    public String login() {
        return "manager/login";
    }

    /**
     * 用户登录验证
     */
    @RequestMapping("/loginUser")
    public String loginUser(HttpServletRequest request, String username, String userpwd) {
        System.out.println("username="+username);
        System.out.println("password="+userpwd);
        logger.info(username + "登录");

        String password = userpwd ;
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            boolean login = userService.login(username, password);
            if (login) {
                request.getSession().setAttribute("user", username);
                System.out.println("longin success!!!");
                return "redirect:/templates/manager/index.html";
            }
        }
        return "redirect:/templates/manager/login.html";
    }

    @Resource
    private ManagerService managerService ;

    @RequestMapping("/show")
    public String showAllUser(HttpServletRequest request,String username,String password){
        System.out.println("username2="+username);
        System.out.println("password2="+password);
        String x = request.getParameter("username") ;
        System.out.println(x);
        ArrayList<User> userlist = managerService.getAllUser() ;
//        JSONObject ret = new JSONObject() ;

        JSONArray retlist = JSONArray.fromObject(userlist) ;
        System.out.println(retlist);
        return retlist.toString();
    }
}
