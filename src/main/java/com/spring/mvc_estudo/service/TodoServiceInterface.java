package com.spring.mvc_estudo.service;

import com.spring.mvc_estudo.models.Todos;

import java.util.List;

public interface TodoServiceInterface {
    List<Todos> findAll();
    Todos update(int id);
    Todos create(String name);
    void delete(int id);
}
