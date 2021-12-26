package com.Ivan.Pomelnikov.TP.SpaceManager.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model")
public class ModelEntity {

    @OneToMany(mappedBy = "ships", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<ShipsEntity> ships;

    @Column()
    private double payload;

    @Column()
    private double maxRouteLength;

    @Column()
    private double speed;
}
