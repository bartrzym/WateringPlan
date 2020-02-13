package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Exposition;
import com.bartrzym.wateringplan.entity.Sprinkler;
import com.bartrzym.wateringplan.entity.Zone;

import java.util.ArrayList;
import java.util.List;

public class ZoneFactory  {

    public static Zone getZone(float height, float width, Exposition exposition) {
        Zone zone = new Zone();
        zone.setHeight(height);
        zone.setWidth(width);
        zone.setExposition(exposition.toString());
        List<Sprinkler> sprinklers = new ArrayList<>();
        zone.setSprinklers(sprinklers);
        return zone;

    }


}
