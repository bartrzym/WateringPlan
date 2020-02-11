package com.bartrzym.wateringplan.entity;

import lombok.Data;

import javax.persistence.*;
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

    @ManyToMany
    private List<Sprinkler> sprinklers;
    @OneToOne
    private Runtime baseRuntime;

    //    public HashMap baseCalculate() {
//
//        HashMap<Zone, Time> calculatedRuntimes = new HashMap<>();
//
//        return this.baseRuntime = calculatedRuntimes;
//    }
}
