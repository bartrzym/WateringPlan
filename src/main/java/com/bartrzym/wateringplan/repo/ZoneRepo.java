package com.bartrzym.wateringplan.repo;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.entity.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepo extends CrudRepository<Zone, Long> {
}
