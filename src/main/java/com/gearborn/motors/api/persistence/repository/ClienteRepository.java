package com.gearborn.motors.api.persistence.repository;

import com.gearborn.motors.api.persistence.entity.ClienteEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ClienteRepository extends ListCrudRepository<ClienteEntity, Integer>{

    /*QUERY METHODS*/
    ClienteEntity findByEmail(String nombreEmail);

}
