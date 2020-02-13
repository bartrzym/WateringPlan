package com.bartrzym.wateringplan.entity;

import com.bartrzym.wateringplan.enums.model.SoilType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float waterPressure;
    private float WaterSupply;
    private SoilType soilType;
    @OneToMany
    private List<Zone> zones;






}
