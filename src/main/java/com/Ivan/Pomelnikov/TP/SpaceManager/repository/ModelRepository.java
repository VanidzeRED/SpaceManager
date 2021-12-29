package com.Ivan.Pomelnikov.TP.SpaceManager.repository;

import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    @Query("select b from ModelEntity b where b.id = :id")
    ModelEntity findByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("delete from ModelEntity b where b.id = :id")
    void deleteByName(@Param("name") String name);
}
