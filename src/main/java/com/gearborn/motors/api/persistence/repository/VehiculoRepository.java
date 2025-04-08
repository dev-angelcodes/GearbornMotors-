package com.gearborn.motors.api.persistence.repository;

import com.gearborn.motors.api.persistence.entity.VehiculoEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface VehiculoRepository extends ListCrudRepository<VehiculoEntity, Integer> {
}
