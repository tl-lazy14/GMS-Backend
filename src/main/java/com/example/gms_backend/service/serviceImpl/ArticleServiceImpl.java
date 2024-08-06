package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.ArticleReq;
import com.example.gms_backend.dto.request.GetListArticleReq;
import com.example.gms_backend.dto.response.GetListArticleRes;
import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.repository.ArticleRepository;
import com.example.gms_backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    @Override
    public GetListArticleRes getListArticles(GetListArticleReq request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, 9);
        List<Article> listArticles = articleRepository.getListArticles(
                request.getCategory(),
                request.getStatus(),
                request.getKeyword(),
                pageable);
        int numArticles = articleRepository.countListArticles(
                request.getCategory(),
                request.getStatus(),
                request.getKeyword());
        return GetListArticleRes.builder()
                .listArticles(listArticles)
                .numArticles(numArticles)
                .build();
    }

    @Override
    public void addArticle(ArticleReq request) {
        Article newArticle = new Article();
        newArticle.setTitle(request.getTitle());
        newArticle.setContent(request.getContent());
        newArticle.setThumbnail(request.getThumbnail());
        newArticle.setCategory(request.getCategory());
        newArticle.setTags(request.getTags());
        newArticle.setView(0L);
        newArticle.setIsPublish(Objects.equals(request.getStatus(), "Published") ? 1 : 0);
        if (Objects.equals(request.getStatus(), "Published")) {
            newArticle.setPublishedAt(new Date());
        }
        newArticle.setCreatedAt(new Date());
        newArticle.setUpdatedAt(new Date());
        articleRepository.save(newArticle);
    }

    @Override
    public void editArticle(String id, ArticleReq request) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setThumbnail(request.getThumbnail());
        article.setCategory(request.getCategory());
        article.setTags(request.getTags());
        article.setUpdatedAt(new Date());
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found!"));
        articleRepository.delete(article);
    }

    @Override
    public Article getArticle(String id) {
        return articleRepository.findById(id).orElseThrow();
    }

    @Override
    public void handlePublish(String id) {
        Article article = articleRepository.findById(id).orElseThrow();
        if (article.getIsPublish() == 1) {
            article.setIsPublish(0);
        } else {
            article.setIsPublish(1);
            article.setPublishedAt(new Date());
        }
        article.setUpdatedAt(new Date());
        articleRepository.save(article);
    }

    @Override
    public void addViewArticle(String id) {
        Article article = articleRepository.findById(id).orElseThrow();
        Long currentView = article.getView();
        article.setView(currentView + 1);
        articleRepository.save(article);
    }

    @Override
    public List<Article> getTopArticles() {
        Pageable pageable = PageRequest.of(0, 6);
        return articleRepository.getTopArticles(pageable);
    }

    @Override
    public List<Article> getOtherArticles(String id) {
        Article currentArticle = articleRepository.findById(id).orElseThrow();
        List<Article> articles = articleRepository.findByCategoryAndIsPublish(currentArticle.getCategory(), 1);
        List<Article> response = new ArrayList<>();
        articles.removeIf(article -> article.getId().equals(id));
        Collections.shuffle(articles);
        if (articles.size() > 3) response = articles.subList(0, 3);
        else response = articles;
        return response;
    }
}
