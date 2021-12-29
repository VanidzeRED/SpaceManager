package com.Ivan.Pomelnikov.TP.SpaceManager.service.impl;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ModelDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.repository.ModelRepository;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<ModelEntity> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public ModelEntity findByName(String name) {
        return modelRepository.findByName(name);
    }

    @Override
    public void addModel(ModelDto modelDto) {
        ModelEntity model = new ModelEntity();
        model.setName(modelDto.getName());
        model.setPayload(modelDto.getPayload());
        model.setSpeed(modelDto.getSpeed());
        model.setMaxRouteLength(modelDto.getMaxRouteLength());
        modelRepository.save(model);
    }

    @Override
    public void deleteByName(ModelDto modelDto) {
        modelRepository.deleteByName(modelDto.getName());
    }
}
