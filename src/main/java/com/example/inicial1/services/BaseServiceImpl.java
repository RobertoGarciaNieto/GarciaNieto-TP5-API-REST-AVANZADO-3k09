package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRespository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRespository <E, ID> baseRespository;

    public BaseServiceImpl(BaseRespository<E, ID> baseRespository){
        this.baseRespository = baseRespository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities=baseRespository.findAll(); //Obtiene de la BD todas las personas que tengamos registradas
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception{
        try {
            Page<E> entities=baseRespository.findAll(pageable); //Obtiene de la BD todas las personas que tengamos registradas
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional=baseRespository.findById(id);  //Se usa porque no sabemos si en la BD va a haber una entidad con el id
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRespository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRespository.findById(id);
            E entityUpdate =entityOptional.get();
            entityUpdate = baseRespository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRespository.existsById(id)){
                baseRespository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}
