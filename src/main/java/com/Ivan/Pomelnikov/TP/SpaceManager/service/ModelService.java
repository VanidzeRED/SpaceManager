package com.Ivan.Pomelnikov.TP.SpaceManager.service;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ModelDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;


import java.util.List;

public interface ModelService {

    List<ModelEntity> findAll();

    ModelEntity findByName(String name);

    void addModel(ModelDto modelDto);

    void deleteByName(ModelDto modelDto);
}
