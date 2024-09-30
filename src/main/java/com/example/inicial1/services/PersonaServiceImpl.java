package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRespository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired // Esto es para la implementacion (se podría hacer también con el constructor)
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRespository<Persona, Long> baseRespository){
        super(baseRespository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //Quey JPQL
            //List<Persona> personas = personaRepository.search(filtro);
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro,  pageable);

            //Quey JPQL
            //Page<Persona> personas = personaRepository.search(filtro,  pageable);
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
