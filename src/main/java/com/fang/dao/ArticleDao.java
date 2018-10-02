package com.fang.dao;

import com.fang.model.Article;

import java.util.ArrayList;

public interface ArticleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    ArrayList<Article> getAllArticle();
}