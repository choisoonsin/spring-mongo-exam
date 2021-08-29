package com.example.mongo.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
public class PersistenceTests {
  
  @Autowired
  private TodoRepository repository;
  private TodoEntity savedEntity;

  @BeforeEach
  public void setupDB() {
    System.out.println("setupDB");
    repository.deleteAll();
    
    // Create a new entity
    TodoEntity entity = new TodoEntity(1, "First todo", false);
    savedEntity = repository.save(entity);
    System.out.println("@@@@@@@@@@@@@@@@@");
    assertEquals(entity, savedEntity);
  }

  @Test
  void create() {
    TodoEntity entity = new TodoEntity(1, "Second Todo", false);
    savedEntity = repository.save(entity);
 
    TodoEntity foundEntity = repository.findById(entity.getId()).get();
    assertEquals(entity.getId(), foundEntity.getId());
    assertEquals(entity.getTitle(), "Second Todo");
  }

  @Test
  void getAll() {
    assertEquals(1, repository.count());
  }
}
