package com.bartrzym.wateringplan.exception;

public class NozzleAlreadyInUseException extends RuntimeException {
    public NozzleAlreadyInUseException(Long id) {
        super("Nozzle already in use" + id);

    }
}
