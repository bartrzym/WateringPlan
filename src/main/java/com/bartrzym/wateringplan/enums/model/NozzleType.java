package com.bartrzym.wateringplan.enums.model;

import lombok.Getter;


public enum NozzleType {
    MINI8("Mini 8"),
    TVAN("T-van");

    @Getter
    private final String displayValue;

    NozzleType(String displayValue) {
        this.displayValue = displayValue;

    }

}
