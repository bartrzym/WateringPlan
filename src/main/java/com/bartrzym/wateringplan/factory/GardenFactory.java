package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Garden;
import com.bartrzym.wateringplan.entity.Zone;
import com.bartrzym.wateringplan.enums.model.SoilType;

import java.util.ArrayList;

public class GardenFactory {

    public static Garden getGarden(float waterPressure, float waterSupply, SoilType soilType){
        Garden garden = new Garden();
        garden.setWaterPressure(waterPressure);
        garden.setWaterSupply(waterSupply);
        garden.setSoilType(soilType);
        garden.setZones(new ArrayList<>());
        garden.setRuntimeByZones(new ArrayList<>());

        return garden;
    }

}
