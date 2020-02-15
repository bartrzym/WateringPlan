package com.bartrzym.wateringplan.bootstrap;

import com.bartrzym.wateringplan.entity.Exposition;
import com.bartrzym.wateringplan.entity.Garden;
import com.bartrzym.wateringplan.entity.RuntimeByZone;
import com.bartrzym.wateringplan.enums.model.NozzleType;
import com.bartrzym.wateringplan.enums.model.SoilType;
import com.bartrzym.wateringplan.enums.model.SprinklerType;
import com.bartrzym.wateringplan.entity.Zone;
import com.bartrzym.wateringplan.factory.*;
import com.bartrzym.wateringplan.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class Bootstrap {
    private NozzleRepo nozzleRepo;
    private SprinklerRepo sprinklerRepo;
    private ZoneRepo zoneRepo;
    private GardenRepo gardenRepo;
    private ClientRepo clientRepo;
    private RuntimeRepo runtimeRepo;
    final static Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    public Bootstrap(RuntimeRepo runtimeRepo, NozzleRepo nozzleRepo, SprinklerRepo sprinklerRepo, ZoneRepo zoneRepo, GardenRepo gardenRepo, ClientRepo clientRepo) {
        this.nozzleRepo = nozzleRepo;
        this.sprinklerRepo = sprinklerRepo;
        this.clientRepo = clientRepo;
        this.gardenRepo = gardenRepo;
        this.runtimeRepo = runtimeRepo;

        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "0.75", 3.3, 6.3));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "1.0", 4.6, 8.1));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "1.5", 5.0, 9.0));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "2.0", 6.0, 9.3));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "3.0", 9.4, 10.6));

        sprinklerRepo.save(SprinklerFactory.getSprinkler(nozzleRepo.getByName("1.0"), SprinklerType.ROTOR, 90));
        Zone zone = ZoneFactory.getZone(8, 8, Exposition.SUNNY);
        Zone zone2 = ZoneFactory.getZone(5, 8, Exposition.SUNNY);
        Zone zone3 = ZoneFactory.getZone(6, 12, Exposition.SUNNY);
        sprinklerRepo.save(zone.calculateSprinklers(nozzleRepo));
        sprinklerRepo.save(zone2.calculateSprinklers(nozzleRepo));
        sprinklerRepo.save(zone3.calculateSprinklers(nozzleRepo));

        LOG.info(zone.calculateRuntime());

        Garden garden = GardenFactory.getGarden(2.5F, 30.3F, SoilType.LOAM);
        garden.getZones().add(zone);
        garden.getZones().add(zone2);
        garden.getZones().add(zone3);
        for (Zone gardenZone : garden.getZones()) {
            gardenZone.calculateRuntime();
        }
        zoneRepo.save(zone);
        zoneRepo.save(zone2);
        zoneRepo.save(zone3);


        garden.wateringCalculator(runtimeRepo);
        gardenRepo.save(garden);


    }


}

