package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Nozzle;

import java.math.BigDecimal;

public class NozzleFactory {

    public static Nozzle getNozzle (String type, String name, double waterExpenditure, double range){
        Nozzle nozzle = new Nozzle();
        nozzle.setName(name);
        nozzle.setRange(BigDecimal.valueOf(range));
        nozzle.setType("Mini8");
        nozzle.setWaterExpenditure(BigDecimal.valueOf(waterExpenditure));
        return nozzle;
    }
}
