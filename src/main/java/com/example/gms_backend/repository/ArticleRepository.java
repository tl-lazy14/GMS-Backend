package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.ExerciseLibrary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {
    @Query("SELECT u FROM Article u WHERE (:category = 'all' OR u.category = :category) " +
            "AND (:status = 'all' OR u.isPublish = CASE WHEN :status = 'Published' THEN 1 ELSE 0 END) " +
            "AND (u.title LIKE %:keyword% OR u.tags LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<Article> getListArticles(@Param("category") String category,
                                  @Param("status") String status,
                                  @Param("keyword") String keyword,
                                  Pageable pageable);

    @Query("SELECT COUNT(u) FROM Article u WHERE (:category = 'all' OR u.category = :category) " +
            "AND (:status = 'all' OR u.isPublish = CASE WHEN :status = 'Published' THEN 1 ELSE 0 END) " +
            "AND (u.title LIKE %:keyword% OR u.tags LIKE %:keyword%)")
    int countListArticles(@Param("category") String category,
                          @Param("status") String status,
                          @Param("keyword") String keyword);

    @Query("SELECT u FROM Article u WHERE u.isPublish = 1 ORDER BY u.view DESC")
    List<Article> getTopArticles(Pageable pageable);

    List<Article> findByCategoryAndIsPublish(String category, int isPublish);
}
