package com.bartrzym.wateringplan.entity;

import com.bartrzym.wateringplan.enums.model.SoilType;
import com.bartrzym.wateringplan.utils.TimeFormatter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class RuntimeByZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int calculatedRuntime;
    @OneToOne
    private Zone zone;

    public void calculateRuntime(SoilType soilType) {
        float waterNeedMultiplier = soilType.getDisplayValue();
        this.calculatedRuntime = Math.round(zone.getBaseRuntime() * waterNeedMultiplier);
    }

}
