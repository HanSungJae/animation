package com.example.demo.service;

import com.example.demo.dto.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    ArticleMapper articleMapper;
    public ArticleService(ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
    }

    public List<Article> getArticles(){
        return articleMapper.findArticles();
    }

}