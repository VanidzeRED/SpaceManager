package com.Ivan.Pomelnikov.TP.SpaceManager.controller;

import com.Ivan.Pomelnikov.TP.SpaceManager.Exception.ShipOnRouteException;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ShipsDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ShipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ships")
public class ShipsController {

    @Autowired
    private ShipsService shipsService;

    @PostMapping("/create")
    public ResponseEntity addShip(@RequestBody ShipsDto shipsDto){
        shipsService.addShip(shipsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteShip(@RequestBody ShipsDto shipsDto){
        shipsService.deleteById(shipsDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ShipsEntity findShip(@RequestBody ShipsDto shipsDto){
        return shipsService.findById(shipsDto.getId());
    }

    @PostMapping("/find_all")
    public List<ShipsEntity> findAllShips(){
        return shipsService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity setShipOnRoute(@RequestBody ShipsDto shipsDto, RoutesDto routesDto) throws ShipOnRouteException {
        shipsService.setShipOnRoute(shipsDto, routesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity removeShipFromRoute (@RequestBody ShipsDto shipsDto) {
        shipsService.removeShipFromRoute(shipsDto);
        return ResponseEntity.ok().build();
    }
}
