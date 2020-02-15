package com.bartrzym.wateringplan.repo;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.entity.RuntimeByZone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuntimeRepo extends CrudRepository<RuntimeByZone, Long> {
}
