package com.example.demo.mapper;

import com.example.demo.dto.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface ArticleMapper {
    List<Article> findArticles();
    List<Article> findAniArticles();

    List<Article> findTop6Articles();
}