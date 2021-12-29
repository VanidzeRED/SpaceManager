package com.Ivan.Pomelnikov.TP.SpaceManager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routes")

public class RoutesEntity {

    @Column()
    private Long id;

    @Column()
    private String aPoint;

    @Column()
    private String bPoint;

    @Column()
    private double routeLength;

    @OneToMany(mappedBy = "ships", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<ShipsEntity> shipsOnRoute;

    @Column()
    private double circulation;
}
