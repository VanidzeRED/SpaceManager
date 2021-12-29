package com.Ivan.Pomelnikov.TP.SpaceManager.service;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;

import java.util.List;

public interface RoutesService {

    List<RoutesEntity> findAll();

    RoutesEntity findById(Long id);

    void addRoute(RoutesDto routesDto);

    void deleteById(RoutesDto routesDto);
}
