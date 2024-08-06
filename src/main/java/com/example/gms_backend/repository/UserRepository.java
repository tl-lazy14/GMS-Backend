package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    List<User> findByRole(String role);

    @Query("SELECT u FROM User u WHERE (u.fullName LIKE %:keyword% OR u.email LIKE %:keyword% OR u.phone LIKE %:keyword%) " +
            "AND u.role = 'GYM_MANAGER' ORDER BY u.createdAt DESC")
    List<User> getListGymManagers(@Param("keyword") String keyword,
                                  Pageable pageable);

    @Query("SELECT COUNT(u) FROM User u WHERE (u.fullName LIKE %:keyword% OR u.email LIKE %:keyword% OR u.phone LIKE %:keyword%) " +
            "AND u.role = 'GYM_MANAGER'")
    int countListGymManagers(@Param("keyword") String keyword);
}
