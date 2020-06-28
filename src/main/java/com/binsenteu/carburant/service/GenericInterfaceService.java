package com.binsenteu.carburant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public interface GenericInterfaceService<T, I> {
	/**
     * @return Return true si insert OK, sinon false
     */
	T insert(T t);

    T update(T t);

    @Transactional
    List<T> findAll();

    Optional<T> findById(I id);
    
    void delete(T t);

    void deleteById(I id);

    

}
