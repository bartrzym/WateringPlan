package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Nozzle;
import com.bartrzym.wateringplan.enums.model.NozzleType;

import java.math.BigDecimal;

public class NozzleFactory {

    public static Nozzle getNozzle (NozzleType nozzleType, String name, double waterExpenditure, double range){
        Nozzle nozzle = new Nozzle();
        nozzle.setName(name);
        nozzle.setRange(BigDecimal.valueOf(range));
        nozzle.setType(nozzleType);
        nozzle.setWaterExpenditure(BigDecimal.valueOf(waterExpenditure));
        return nozzle;
    }
}
