package com.luv2code.demo.service;

import java.util.List;

public interface AbstractService<T> {

    Integer save(T object);

    T findById(Integer id);

    Integer delete(Integer id);

    List<T> findAll();
}
