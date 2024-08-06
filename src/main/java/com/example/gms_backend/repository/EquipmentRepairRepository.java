package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.EquipmentRepair;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepairRepository extends JpaRepository<EquipmentRepair, String> {
    @Query("SELECT u FROM EquipmentRepair u WHERE (:status = 'all' OR u.status = :status) " +
            "AND u.equipment.gym.id = :gymId " +
            "AND (u.equipment.name LIKE %:keyword% OR u.code LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<EquipmentRepair> getListEquipmentRepair(@Param("status") String status,
                                                 @Param("gymId") String gymId,
                                                 @Param("keyword") String keyword,
                                                 Pageable pageable);

    @Query("SELECT COUNT(u) FROM EquipmentRepair u WHERE (:status = 'all' OR u.status = :status) " +
            "AND u.equipment.gym.id = :gymId " +
            "AND (u.equipment.name LIKE %:keyword% OR u.code LIKE %:keyword%)")
    int countListEquipmentRepair(@Param("status") String status,
                                 @Param("gymId") String gymId,
                                 @Param("keyword") String keyword);

    @Query("SELECT u FROM EquipmentRepair u WHERE (:status = 'all' OR u.status = :status) " +
            "AND u.equipment.gym.id = :gymId " +
            "ORDER BY u.createdAt DESC")
    List<EquipmentRepair> exportListEquipmentRepair(@Param("status") String status,
                                                    @Param("gymId") String gymId);

    @Query("SELECT u FROM EquipmentRepair u WHERE u.code = :code " +
            "AND (u.status = 'Pending' OR u.status = 'In progress')")
    List<EquipmentRepair> findExistEquipmentNotRepair(String code);

    @Query("SELECT COALESCE(SUM(e.repairCost), 0) FROM EquipmentRepair e WHERE (:gymId = 'all' OR e.equipment.gym.id = :gymId)")
    Double getTotalCostRepairEquipment(@Param("gymId") String gymId);

    @Query("SELECT COALESCE(SUM(e.repairCost), 0) FROM EquipmentRepair e WHERE (:gymId = 'all' OR e.equipment.gym.id = :gymId)" +
            "AND YEAR(e.repairDate) = :year AND MONTH(e.repairDate) = :month")
    Double getCostRepairEquipmentByMonth(@Param("gymId") String gymId,
                                         @Param("year") int year,
                                         @Param("month") int month);
}
