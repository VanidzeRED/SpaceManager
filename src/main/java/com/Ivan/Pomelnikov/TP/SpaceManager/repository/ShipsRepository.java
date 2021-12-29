package com.Ivan.Pomelnikov.TP.SpaceManager.repository;

import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ShipsRepository extends JpaRepository<ShipsEntity, Long> {

    @Query("select b from ShipsEntity b where b.id = :id")
    ShipsEntity findByNum(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("delete from ShipsEntity b where b.id = :id")
    void deleteByNum(@Param("id") Long id);
}
