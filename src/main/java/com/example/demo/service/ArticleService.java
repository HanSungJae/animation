package com.example.demo.service;

import com.example.demo.dto.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleMapper articleMapper;
    public ArticleService(ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
    }

    public List<Article> getArticles(){
        return articleMapper.findArticles();
    }
    public List<Article> getAnimation(){return articleMapper.findAniArticles();}

    public List<Article> getEmoji(){return articleMapper.findEmojiArticles();}
    public List<Article> getTop6Articles(){return articleMapper.findTop6Articles();}

    public Article getArticle(int articleId){
        return articleMapper.getArticle(articleId);
    }

    public void createArticle(Article article){
        articleMapper.createArticle(article);
    }

}
