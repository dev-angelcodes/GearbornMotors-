package com.gearborn.motors.api.service;

import com.gearborn.motors.api.persistence.entity.VehiculoEntity;
import com.gearborn.motors.api.persistence.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    public void save(VehiculoEntity vehiculo){
        this.vehiculoRepository.save(vehiculo);
    }

    public List<VehiculoEntity> findAll(){
        return this.vehiculoRepository.findAll();
    }
}
