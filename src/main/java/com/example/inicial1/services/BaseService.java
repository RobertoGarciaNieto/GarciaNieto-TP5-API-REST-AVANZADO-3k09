package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;     //Trae una lista de todas las entidades que queramos traer que se encuentren en la BD
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;    //Trae una entidad de acuerdo a su num de id
    public E save(E entity) throws Exception;   //Crea nuevas entidades
    public E update(ID id, E entity) throws Exception;    //Actualiza
    public boolean delete(ID id) throws Exception;    //Elimina

}
