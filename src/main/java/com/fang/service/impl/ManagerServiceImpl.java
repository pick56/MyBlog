package com.fang.service.impl;

import com.fang.dao.ArticleDao;
import com.fang.dao.ContentDao;
import com.fang.dao.UserDao;
import com.fang.model.Article;
import com.fang.model.Content;
import com.fang.model.User;
import com.fang.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private  UserDao userDao ;
    @Resource
    private  ArticleDao articleDao ;
    @Resource
    private  ContentDao contentDao ;
    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> userlist = userDao.getAllUser() ;
        return userlist ;
    }

    @Override
    public int addArticle(Article article){
        return articleDao.insert(article);
    }
    @Override
    public int addContent(Content content){
        return contentDao.insert(content);
    }
    @Override
    public int getMaxContentId(){
        return contentDao.getMaxId();
    }

    @Override
    public ArrayList<Article> getAllArticle() {
        return articleDao.getAllArticle();
    }

}
