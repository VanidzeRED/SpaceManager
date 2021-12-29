package com.Ivan.Pomelnikov.TP.SpaceManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ships")
public class ShipsController {

    /*@Autowired
    private ShipsService shipsService;

    @PostMapping("/create")
    public ResponseEntity createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.createCategory(categoryDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody CategoryDto categoryDto){
        categoryService.deleteByName(categoryDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public CategoryEntity findCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.findByName(categoryDto.getName());
    }

    @PostMapping("/find_all")
    public List<CategoryEntity> findAllCategories(){
        return categoryService.findAll();
    }*/
}
