package com.spring.mvc_estudo.controllers;

import com.spring.mvc_estudo.dto.Create;
import com.spring.mvc_estudo.dto.Delete;
import com.spring.mvc_estudo.dto.Update;
import com.spring.mvc_estudo.models.Todos;
import com.spring.mvc_estudo.service.TodoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoServiceImp todoServiceImp;

    // Mount screen
    @GetMapping("/")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("todoList");

        modelAndView.addObject("todoList", todoServiceImp.findAll());

        return modelAndView;
    }

    // API
    @PostMapping("/create")
    @ResponseBody
    public Todos create(@RequestBody Create name) {
        return this.todoServiceImp.create(name.getName());
    }

    @PostMapping("/update")
    @ResponseBody
    public Todos update(@RequestBody Update todoData) {
        System.out.println("id" + todoData.getId());
        return this.todoServiceImp.update(todoData.getId());
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody Delete deleteId) {
        this.todoServiceImp.delete(deleteId.getId());
    }
}
