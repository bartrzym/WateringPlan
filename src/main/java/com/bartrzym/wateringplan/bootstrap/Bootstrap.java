package com.bartrzym.wateringplan.bootstrap;

import com.bartrzym.wateringplan.entity.Exposition;
import com.bartrzym.wateringplan.enums.model.NozzleType;
import com.bartrzym.wateringplan.enums.model.SprinklerType;
import com.bartrzym.wateringplan.entity.Zone;
import com.bartrzym.wateringplan.factory.NozzleFactory;
import com.bartrzym.wateringplan.factory.SprinklerFactory;
import com.bartrzym.wateringplan.factory.ZoneFactory;
import com.bartrzym.wateringplan.repo.NozzleRepo;
import com.bartrzym.wateringplan.repo.SprinklerRepo;
import com.bartrzym.wateringplan.repo.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Bootstrap {
    private NozzleRepo nozzleRepo;
    private SprinklerRepo sprinklerRepo;
    private ZoneRepo zoneRepo;
    final static Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    public Bootstrap(NozzleRepo nozzleRepo, SprinklerRepo sprinklerRepo, ZoneRepo zoneRepo) {
        this.nozzleRepo = nozzleRepo;
        this.sprinklerRepo = sprinklerRepo;


        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "0.75", 3.3, 6.3));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "1.0", 4.6, 8.1));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "1.5", 5.0, 9.0));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "2.0", 6.0, 9.3));
        nozzleRepo.save(NozzleFactory.getNozzle(NozzleType.MINI8, "3.0", 9.4, 10.6));

        sprinklerRepo.save(SprinklerFactory.getSprinkler(nozzleRepo.getByName("1.0"), SprinklerType.ROTOR, 90));
        Zone zone = ZoneFactory.getZone(8, 8, Exposition.SUNNY);
        sprinklerRepo.save(zone.calculateSprinklers(nozzleRepo));
        LOG.info(zone.calculateRuntime());
        zoneRepo.save(zone);

    }
}
