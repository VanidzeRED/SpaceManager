package com.Ivan.Pomelnikov.TP.SpaceManager.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model")
public class ModelEntity {

    @Column()
    @Id
    private String name;

    @Column()
    private double payload;

    @Column()
    private double maxRouteLength;

    @Column()
    private double speed;
}
