package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Nozzle;
import com.bartrzym.wateringplan.entity.Sprinkler;
import com.bartrzym.wateringplan.enums.model.SprinklerType;

public class SprinklerFactory {

    public static Sprinkler getSprinkler(Nozzle nozzle, SprinklerType type, int arc){
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.setNozzle(nozzle);
        sprinkler.setType(type.toString());
        sprinkler.setArc(arc);
        return sprinkler;
    }
}
