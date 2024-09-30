package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.BaseRespository;
import com.example.inicial1.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRespository<Localidad, Long> baseRespository) {
        super(baseRespository);
    }
}
