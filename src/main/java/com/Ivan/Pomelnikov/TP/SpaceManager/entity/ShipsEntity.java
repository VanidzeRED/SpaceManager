package com.Ivan.Pomelnikov.TP.SpaceManager.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ships")
public class ShipsEntity {

    @Column()
    private Long id;

    @Column()
    private String model;

    @ManyToOne
    @JoinColumn(name = "id")
    private RoutesEntity route;

    @Column()
    private double timeOnRoute;

    @Column()
    private double circulation;
}
