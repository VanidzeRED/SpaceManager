package com.Ivan.Pomelnikov.TP.SpaceManager.repository;

import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoutesRepository extends JpaRepository<RoutesEntity, Long> {

    @Query("select b from RoutesEntity b where b.id = :id")
    RoutesEntity findByNum(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("delete from RoutesEntity b where b.id = :id")
    void deleteByNum(@Param("id") Long id);
}
