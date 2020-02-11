package com.bartrzym.wateringplan.factory;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.entity.Garden;
import com.bartrzym.wateringplan.entity.Nozzle;

import java.math.BigDecimal;

public class ClientFactory {

    public static Client getClient(String name){
        Client client = new Client();
        client.setName(name);
        return client;
    }
}
