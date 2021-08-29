package com.example.mongo.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoRepository extends PagingAndSortingRepository<TodoEntity, String> {
  // Optional<TodoEntity> findByTodoId(int todoId);

  List<TodoEntity> findByUserId(int userId);
}
