package com.bartrzym.wateringplan.repo;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.entity.Sprinkler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprinklerRepo extends CrudRepository<Sprinkler, Long> {
}
