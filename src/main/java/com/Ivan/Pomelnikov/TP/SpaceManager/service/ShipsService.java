package com.Ivan.Pomelnikov.TP.SpaceManager.service;

import com.Ivan.Pomelnikov.TP.SpaceManager.Exception.ShipOnRouteException;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ShipsDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;

import java.util.List;

public interface ShipsService {

    List<ShipsEntity> findAll();

    ShipsEntity findById(Long id);

    void addShip(ShipsDto shipsDto);

    void deleteById(ShipsDto shipsDto);

    void setShipOnRoute(ShipsDto shipsDto, RoutesDto routesDto) throws ShipOnRouteException;

    void putShipFromRoute(ShipsDto shipsDto);
}
