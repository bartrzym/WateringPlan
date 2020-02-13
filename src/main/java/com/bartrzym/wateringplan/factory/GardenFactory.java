package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Garden;
import com.bartrzym.wateringplan.enums.model.SoilType;

public class GardenFactory {

    public static Garden getGarden(float waterPressure, float waterSupply, SoilType soilType){
        Garden garden = new Garden();
        garden.setWaterPressure(waterPressure);
        garden.setWaterSupply(waterSupply);
        garden.setSoilType(soilType);

        return garden;
    }

}
