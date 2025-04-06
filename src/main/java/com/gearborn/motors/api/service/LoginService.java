package com.gearborn.motors.api.service;

import com.gearborn.motors.api.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public LoginService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


}
