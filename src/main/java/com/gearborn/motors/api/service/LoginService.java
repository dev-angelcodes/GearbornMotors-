package com.gearborn.motors.api.service;

import com.gearborn.motors.api.persistence.entity.ClienteEntity;
import com.gearborn.motors.api.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class LoginService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public LoginService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void save(ClienteEntity cliente){
        this.clienteRepository.save(cliente);
    }

    public ClienteEntity findByEmail(String nombreEmail){
        return this.clienteRepository.findByEmail(nombreEmail);
    }

    //Metodo par encriptar contraseña que introduce el user en la pantalla de Login
    public static String encriptarMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar con MD5", e);
        }
    }
}
