package com.Ivan.Pomelnikov.TP.SpaceManager.dto;

import lombok.Data;

@Data
public class RoutesDto {

    private Long id;

    private String aPoint;

    private String bPoint;

    private double routeLength;

    private double circulation;
}
