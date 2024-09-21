package com.example.inicial1.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;     //Trae una lista de todas las entidades que queramos traer que se encuentren en la BD
    public E findById(Long id) throws Exception;    //Trae una entidad de acuerdo a su num de id
    public E save(E entity) throws Exception;   //Crea nuevas entidades
    public E update(Long id, E entity) throws Exception;    //Actualiza
    public boolean delete(Long id) throws Exception;    //Elimina
}
