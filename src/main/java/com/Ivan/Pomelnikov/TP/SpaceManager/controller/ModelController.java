package com.Ivan.Pomelnikov.TP.SpaceManager.controller;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ModelDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/create")
    public ResponseEntity addModel(@RequestBody ModelDto modelDto){
        modelService.addModel(modelDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteModel(@RequestBody ModelDto modelDto){
        modelService.deleteByName(modelDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ModelEntity findModel(@RequestBody ModelDto modelDto){
        return modelService.findByName(modelDto.getName());
    }

    @PostMapping("/find_all")
    public List<ModelEntity> findAllShips(){
        return modelService.findAll();
    }
}
