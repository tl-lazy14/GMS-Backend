package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.ArticleReq;
import com.example.gms_backend.dto.request.ExerciseReq;
import com.example.gms_backend.dto.request.GetListArticleReq;
import com.example.gms_backend.dto.response.GetListArticleRes;
import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.ExerciseLibrary;

import java.util.List;

public interface ArticleService {
    GetListArticleRes getListArticles(GetListArticleReq request);
    void addArticle(ArticleReq request);
    void editArticle(String id, ArticleReq request);
    void deleteArticle(String id);
    Article getArticle(String id);
    void handlePublish(String id);
    void addViewArticle(String id);
    List<Article> getTopArticles();
    List<Article> getOtherArticles(String id);
}
