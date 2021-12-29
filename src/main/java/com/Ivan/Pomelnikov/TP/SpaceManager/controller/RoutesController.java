package com.Ivan.Pomelnikov.TP.SpaceManager.controller;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private RoutesService routesService;

    @PostMapping("/create")
    public ResponseEntity addRoute(@RequestBody RoutesDto routesDto){
        routesService.addRoute(routesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteRoute(@RequestBody RoutesDto routesDto){
        routesService.deleteById(routesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public RoutesEntity findRoute(@RequestBody RoutesDto routesDto){
        return routesService.findById(routesDto.getId());
    }

    @PostMapping("/find_all")
    public List<RoutesEntity> findAllShips(){
        return routesService.findAll();
    }
}
