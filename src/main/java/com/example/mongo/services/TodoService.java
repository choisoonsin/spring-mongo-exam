package com.example.mongo.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface TodoService {

  @GetMapping(value = "/todo/{id}")
  Todo getProduct(@PathVariable int id);

}