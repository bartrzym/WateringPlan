package com.bartrzym.wateringplan.repo;

import com.bartrzym.wateringplan.entity.Nozzle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface NozzleRepo extends CrudRepository<Nozzle, Long> {
    Nozzle getByName(String name);
    Nozzle getByRange(BigDecimal range);
    boolean existsClientByName(String name);
}
