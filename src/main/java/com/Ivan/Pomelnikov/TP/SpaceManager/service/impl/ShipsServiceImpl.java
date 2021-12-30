package com.Ivan.Pomelnikov.TP.SpaceManager.service.impl;

import com.Ivan.Pomelnikov.TP.SpaceManager.Exception.ShipOnRouteException;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ShipsDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.repository.ModelRepository;
import com.Ivan.Pomelnikov.TP.SpaceManager.repository.RoutesRepository;
import com.Ivan.Pomelnikov.TP.SpaceManager.repository.ShipsRepository;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ShipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShipsServiceImpl implements ShipsService {

    @Autowired
    private ShipsRepository shipsRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<ShipsEntity> findAll() {
        return shipsRepository.findAll();
    }

    @Override
    public ShipsEntity findById(Long id) {
        return shipsRepository.findByNum(id);
    }

    @Override
    public void addShip(ShipsDto shipsDto) {
        ShipsEntity ship = new ShipsEntity();
        ship.setId(shipsDto.getId());
        ship.setModel(shipsDto.getModel());
        ship.setCirculation(0.);
        ship.setTimeOnRoute(0.);
        shipsRepository.save(ship);
    }

    @Override
    public void deleteById(ShipsDto shipsDto) {
        shipsRepository.deleteByNum(shipsDto.getId());
    }

    @Override
    public void setShipOnRoute(ShipsDto shipsDto, RoutesDto routesDto) throws ShipOnRouteException {
        ShipsEntity ship = new ShipsEntity();
        RoutesEntity route = new RoutesEntity();

        ship.setId(shipsDto.getId());
        ship.setModel(shipsDto.getModel());

        ModelEntity model = modelRepository.findByName(ship.getModel());

        route.setId(routesDto.getId());
        route.setRouteLength(routesDto.getRouteLength());
        route.setAPoint(routesDto.getAPoint());
        route.setBPoint(routesDto.getBPoint());
        route.setCirculation(routesDto.getCirculation());

        if (model.getMaxRouteLength() < route.getRouteLength()){
            throw new ShipOnRouteException();
        }
        double timeOnRoute = Math.round(route.getRouteLength() / model.getSpeed() * 100.)/100.;
        double circulation = Math.round(model.getSpeed() / timeOnRoute * 100.)/100.;
        double sumCirculation = route.getCirculation() + circulation;

        Set<ShipsEntity> shipsEntitySet;
        ship.setRoute(route);
        ship.setTimeOnRoute(timeOnRoute);
        ship.setCirculation(circulation);
        route.setCirculation(sumCirculation);
        shipsEntitySet = route.getShipsOnRoute();
        if (shipsEntitySet != null){
            shipsEntitySet.add(ship);
        } else {
            shipsEntitySet = Set.of(ship);
        }
        route.setShipsOnRoute(shipsEntitySet);

        routesRepository.save(route);
        shipsRepository.save(ship);
    }

    @Override
    public void removeShipFromRoute(ShipsDto shipsDto) {
        ShipsEntity ship = shipsRepository.findByNum(shipsDto.getId());
        RoutesEntity route = routesRepository.findByNum(ship.getRoute().getId());

        double circulation = ship.getCirculation();
        ship.setRoute(null);
        ship.setCirculation(0.);
        ship.setTimeOnRoute(0.);

        Set<ShipsEntity> shipsEntitySet = route.getShipsOnRoute();
        shipsEntitySet.remove(ship);
        route.setShipsOnRoute(shipsEntitySet);
        route.setCirculation(route.getCirculation() - circulation);

        routesRepository.save(route);
        shipsRepository.save(ship);
    }
}
