package com.fang.service;

import com.fang.model.Article;
import com.fang.model.Content;
import com.fang.model.User;

import java.util.ArrayList;

public interface ManagerService {
    ArrayList<User> getAllUser() ;
    int addArticle(Article article);
    int addContent(Content content) ;
    int getMaxContentId() ;
    ArrayList<Article> getAllArticle();
}
