package com.spring.mvc_estudo.service;

import com.spring.mvc_estudo.models.Todos;
import com.spring.mvc_estudo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoServiceInterface {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todos> findAll() {
        return todoRepository.findAll();
    }

    public Todos update(int id) {
        Optional<Todos> existingTodo = this.todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            Todos existingTodoOpt = existingTodo.get();

            String status = existingTodoOpt.getStatus();

            System.out.println("status: " + status);

            if (Objects.equals(status, "pendente")) {
                System.out.println("entrou no if");
                existingTodoOpt.setStatus("sucesso");
            } else {
                System.out.println("entrou no else");
                existingTodoOpt.setStatus("pendente");
            }

            System.out.println("existingTodoOpt: " + existingTodoOpt.getStatus());

            return this.todoRepository.save(existingTodoOpt);
        }
        return null;
    }

    public Todos create(String name) {
        Todos newTodo = new Todos();

        newTodo.setName(name);
        newTodo.setStatus("pendente");

        return this.todoRepository.save(newTodo);
    }

    public void delete(int id) {
        this.todoRepository.deleteById(id);
    }
}
