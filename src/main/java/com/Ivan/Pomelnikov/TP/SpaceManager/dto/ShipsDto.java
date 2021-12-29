package com.Ivan.Pomelnikov.TP.SpaceManager.dto;

import lombok.Data;

@Data
public class ShipsDto {

    private Long id;

    private String model;

    private double timeOnRoute;

    private double circulation;
}
