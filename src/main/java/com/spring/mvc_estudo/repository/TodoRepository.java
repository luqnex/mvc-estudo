package com.spring.mvc_estudo.repository;

import com.spring.mvc_estudo.models.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Integer> {

}
