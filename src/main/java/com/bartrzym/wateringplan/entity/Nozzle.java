package com.bartrzym.wateringplan.entity;

import com.bartrzym.wateringplan.enums.model.NozzleType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Nozzle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private NozzleType type;
    private String name;
    private BigDecimal waterExpenditure; //liters per minute
    private BigDecimal range;// meters


}
