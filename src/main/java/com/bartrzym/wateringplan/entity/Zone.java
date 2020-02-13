package com.bartrzym.wateringplan.entity;

import com.bartrzym.wateringplan.enums.model.SprinklerType;
import com.bartrzym.wateringplan.factory.SprinklerFactory;
import com.bartrzym.wateringplan.repo.NozzleRepo;
import com.bartrzym.wateringplan.utils.TimeFormatter;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float height;
    private float width;
    private String exposition;
    private int baseRuntime;

    @ManyToMany
    private List<Sprinkler> sprinklers;

    public Sprinkler calculateSprinklers(NozzleRepo nozzleRepo) {
        List<Sprinkler> sprinklers = new ArrayList<>();
        Nozzle nozzle = null;
        float maxRange = Math.min(height, width);
        for (Nozzle nozzles : nozzleRepo.findAll()) {
            if (nozzles.getRange().floatValue() > maxRange) {
                nozzle = nozzles;
                break;
            }

        }

        Sprinkler sprinkler = SprinklerFactory.getSprinkler(nozzle, SprinklerType.ROTOR, 90);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);
        sprinklers.add(sprinkler);

        this.sprinklers = sprinklers;
        return sprinkler;
    }

    public String calculateRuntime() {
        Sprinkler sprinkler = getSprinklers().get(0);
        float waterDrop = sprinkler.getNozzle().getWaterExpenditure().floatValue() * 60 / 1000;
        float area = height * width;
        int multiplier = 360 / sprinkler.getArc();
        float totalWaterDrop = waterDrop * 1000 / area * multiplier;
        float waterNeed = 5f;
        int timeInSeconds = Math.round(waterNeed / totalWaterDrop * 3600);
        this.baseRuntime = timeInSeconds;

        return TimeFormatter.formatter(timeInSeconds);

    }
}
