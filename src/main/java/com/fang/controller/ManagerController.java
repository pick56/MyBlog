package com.fang.controller;

import com.fang.model.Article;
import com.fang.model.Content;
import com.fang.model.User;
import com.fang.service.ManagerService;
import com.fang.utils.JsonDateValueProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;


import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mgr")
public class ManagerController {
    @Resource
    private ManagerService managerService ;

    @ResponseBody
    @RequestMapping("/showalluser")
    public String showAllUser(HttpServletRequest request,HttpServletResponse response){
//        System.out.println("username3="+username);
//        System.out.println("password3="+password);
        //String xx = request.getParameter("username") ;
        //System.out.println(xx);
        ArrayList<User> userlist = managerService.getAllUser() ;
        JSONArray retlist = JSONArray.fromObject(userlist) ;
        //System.out.println(retlist);
        return retlist.toString();
    }

    @RequestMapping("/addArticle")
    public String addArticle(HttpServletRequest request){
        String title = request.getParameter("title") ;
        String contentstr = request.getParameter("content") ;
        String keywords = request.getParameter("keywords") ;
        String describe = request.getParameter("describe") ;
        String tags = request.getParameter("tags") ;
        String titlepic = request.getParameter("titlepic") ;
        String visibility = request.getParameter("visibility") ;
        //String time = request.getParameter("time") ;
        Content content = new Content() ;
        content.setContent(contentstr);
        managerService.addContent(content) ;

        int maxid = managerService.getMaxContentId() ;

        System.out.println("内容最大序号："+maxid);

        Article article = new Article() ;
        article.setContentid(maxid);
        article.setTitle(title);
        article.setKeyvalue(keywords);
        article.setAbstr(describe);
        article.setCategoryvalue(tags);
        article.setCreatedate(new Date());
        int ret = managerService.addArticle(article) ;
        System.out.println("文章ret="+ret);

//        System.out.println(title);
//        System.out.println(contentstr);
//        System.out.println(keywords);
//        System.out.println(describe);
//        System.out.println(tags);
//        System.out.println(titlepic);
//        System.out.println(visibility);
//        System.out.println(time);

        return "redirect:/templates/manager/article.html" ;
    }

    @ResponseBody
    @RequestMapping("/showallarticle")
    public String showAllArticle(){
        System.out.println("with out parameter");
        ArrayList<Article> articlelist = managerService.getAllArticle() ;
        //增加对date类型转化的支持
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray retlist = JSONArray.fromObject(articlelist,jsonConfig) ;

        System.out.println(retlist);
        return retlist.toString();
    }
}
