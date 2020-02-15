package com.bartrzym.wateringplan.enums.model;

import lombok.Getter;

public enum SoilType {
    SAND(1.75f),
    LOAMY_SAND(1.5f),
    SANDY_LOAM(1.25f),
    LOAM(1),
    CLAY_LOAM(0.75f),
    CLAY(0.5f);

    @Getter
    private final float displayValue;

    SoilType(float displayValue) {
        this.displayValue = displayValue;

    }
}
