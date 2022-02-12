package com.example.restapp.service;

import com.example.restapp.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<ID>, ID> {
    E save(E e);

    E findById(ID id);

    boolean existsById(ID id);

    long count();

    Collection<E> findAll();

    List<E> saveAll(Iterable<E> itr);

    void delete(ID id);
}
