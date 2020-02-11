package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.*;
import com.bartrzym.wateringplan.repo.NozzleRepo;
import com.bartrzym.wateringplan.repo.ZoneRepo;

import java.util.ArrayList;
import java.util.List;

public class ZoneFactory {
    private NozzleRepo nozzleRepo;

    public static Zone getZone(float height, float width, Exposition exposition) {
        Zone zone = new Zone();
        zone.setHeight(height);
        zone.setWidth(width);
        zone.setExposition(exposition.toString());
        List<Sprinkler> sprinklers = new ArrayList<>();
        zone.setSprinklers(sprinklers);
        return zone;

    }

    private List<Sprinkler> calculateSprinklers(Zone zone) {
        List<Sprinkler> sprinklers = new ArrayList<>();
        Nozzle nozzle = null;
        float maxRange = Math.min(zone.getHeight(), zone.getWidth());
        for (Nozzle nozzles : nozzleRepo.findAll()) {
            if (nozzles.getRange().floatValue() > maxRange) {
                nozzle = nozzles;
            }

        }

        Sprinkler sprinkler = SprinklerFactory.getSprinkler(nozzle, SprinklerType.ROTOR, 90);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);

        return sprinklers;

    }
}
