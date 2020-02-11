package com.bartrzym.wateringplan.repo;

import com.bartrzym.wateringplan.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
}
