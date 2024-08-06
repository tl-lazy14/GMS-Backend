package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.EquipmentCategory;
import com.example.gms_backend.entity.Gym;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {
    @Query("SELECT u FROM Equipment u WHERE (:categoryId = 'all' OR u.equipmentCategory.id = :categoryId) " +
            "AND u.gym.id = :gymId " +
            "AND u.name LIKE %:keyword% " +
            "ORDER BY u.purchaseDate DESC")
    List<Equipment> getListEquipment(@Param("categoryId") String categoryId,
                                     @Param("gymId") String gymId,
                                     @Param("keyword") String keyword,
                                     Pageable pageable);

    @Query("SELECT COUNT(u) FROM Equipment u WHERE (:categoryId = 'all' OR u.equipmentCategory.id = :categoryId) " +
            "AND u.gym.id = :gymId " +
            "AND u.name LIKE %:keyword%")
    int countListEquipment(@Param("categoryId") String categoryId,
                           @Param("gymId") String gymId,
                           @Param("keyword") String keyword);

    @Query("SELECT u FROM Equipment u WHERE (:categoryId = 'all' OR u.equipmentCategory.id = :categoryId) " +
            "AND u.gym.id = :gymId " +
            "ORDER BY u.purchaseDate DESC")
    List<Equipment> exportListEquipment(@Param("categoryId") String categoryId,
                                        @Param("gymId") String gymId);

    List<Equipment> findByGym(Gym gym);

    @Query("SELECT COALESCE(SUM(e.totalQuantity), 0) FROM Equipment e WHERE (:gymId = 'all' OR e.gym.id = :gymId)")
    int getTotalQuantityEquipment(@Param("gymId") String gymId);

    @Query("SELECT COALESCE(SUM(e.totalPrice), 0) FROM Equipment e WHERE (:gymId = 'all' OR e.gym.id = :gymId)")
    Double getTotalCostPurchaseEquipment(@Param("gymId") String gymId);
}
