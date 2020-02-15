package com.bartrzym.wateringplan.entity;

import com.bartrzym.wateringplan.enums.model.SoilType;
import com.bartrzym.wateringplan.factory.RuntimeByZoneFactory;
import com.bartrzym.wateringplan.repo.RuntimeRepo;
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
    @OneToMany
    private List<RuntimeByZone> runtimeByZones;

    public void wateringCalculator(RuntimeRepo runtimeRepo) {
        for (Zone gardenZone : zones) {
            RuntimeByZone runtimeByZone = RuntimeByZoneFactory.getRuntime();
            runtimeByZones.add(runtimeByZone);
            runtimeByZone.setZone(gardenZone);
            runtimeByZone.calculateRuntime(soilType);
            runtimeRepo.save(runtimeByZone);
        }
    }
}
