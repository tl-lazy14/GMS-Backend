package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.ArticleReq;
import com.example.gms_backend.dto.request.ExerciseReq;
import com.example.gms_backend.dto.request.GetListArticleReq;
import com.example.gms_backend.dto.request.GetListExercisesReq;
import com.example.gms_backend.dto.response.GetListArticleRes;
import com.example.gms_backend.dto.response.GetListExerciseRes;
import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.ExerciseLibrary;
import com.example.gms_backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/get-list-article")
    public ResponseEntity<GetListArticleRes> getListArticle(@RequestParam String category,
                                                            @RequestParam String status,
                                                            @RequestParam String keyword,
                                                            @RequestParam int page) {
        GetListArticleReq request = new GetListArticleReq(category, status, keyword, page);
        GetListArticleRes response = articleService.getListArticles(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-article/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable(value = "id") String id) {
        Article response = articleService.getArticle(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-article")
    public ResponseEntity<String> addArticle(@RequestBody ArticleReq request) {
        articleService.addArticle(request);
        return ResponseEntity.ok("Article created successfully!");
    }

    @PutMapping("/edit-article/{id}")
    public ResponseEntity<String> editArticle(@PathVariable(value = "id") String id,
                                              @RequestBody ArticleReq request) {
        articleService.editArticle(id, request);
        return ResponseEntity.ok("Article updated successfully!");
    }

    @DeleteMapping("/delete-article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok("Article deleted successfully!");
    }

    @PutMapping("/handle-publish/{id}")
    public void handlePublish(@PathVariable(value = "id") String id) {
        articleService.handlePublish(id);
    }

    @PutMapping("/add-view/{id}")
    public void addViewArticle(@PathVariable(value = "id") String id) {
        articleService.addViewArticle(id);
    }

    @GetMapping("/get-top-articles")
    public ResponseEntity<List<Article>> getTopArticles() {
        List<Article> response = articleService.getTopArticles();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-other-articles/{id}")
    public ResponseEntity<List<Article>> getOtherArticles(@PathVariable(value = "id") String id) {
        List<Article> response = articleService.getOtherArticles(id);
        return ResponseEntity.ok().body(response);
    }
}
