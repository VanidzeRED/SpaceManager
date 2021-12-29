package com.Ivan.Pomelnikov.TP.SpaceManager.service.impl;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.repository.RoutesRepository;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RouteServiceImpl implements RoutesService {

    @Autowired
    private RoutesRepository routesRepository;
    @Override
    public List<RoutesEntity> findAll() {
        return routesRepository.findAll();
    }

    @Override
    public RoutesEntity findById(Long id) {
        return routesRepository.findByNum(id);
    }

    @Override
    public void addRoute(RoutesDto routesDto) {
        RoutesEntity route = new RoutesEntity();
        route.setId(routesDto.getId());
        route.setAPoint(routesDto.getAPoint());
        route.setBPoint(routesDto.getBPoint());
        route.setRouteLength(routesDto.getRouteLength());
        route.setCirculation(0.);
        routesRepository.save(route);
    }

    @Override
    public void deleteById(RoutesDto routesDto) {
        routesRepository.deleteByNum(routesDto.getId());
    }
}
