package com.example.mongo.servicesImpl;

import java.io.IOException;

import com.example.mongo.messages.ResultMessage;
import com.example.mongo.persistence.TodoEntity;
import com.example.mongo.persistence.TodoRepository;
import com.example.mongo.services.Todo;
import com.example.mongo.services.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoServiceImpl implements TodoService{

  private ObjectMapper mapper;
  private TodoRepository todoRepository;

  @Autowired
  public TodoServiceImpl(ObjectMapper mapper, TodoRepository todoRepository) {
    this.mapper = mapper;
    this.todoRepository = todoRepository;
  }

  @Override
  public Todo selectUserTodo(int userId) {

    HttpClient client = HttpClientBuilder.create().build();

    try {
      HttpResponse res = client.execute(new HttpGet("https://jsonplaceholder.typicode.com/todos/"+userId));
      int statusCode = res.getStatusLine().getStatusCode();
      if ( HttpStatus.SC_OK == statusCode ) {
        // jsonMapper.readValue(res.getEntity(""), valueType)
        String body = EntityUtils.toString(res.getEntity());
        System.out.println(body);

        return mapper.readValue(body, Todo.class);
      } 
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public ResponseEntity<ResultMessage> craeteUserTodo(int userId, TodoEntity param) {

    TodoEntity entity = todoRepository.save(new TodoEntity(userId, param.getTitle(), param.isCompleted()));
    
    if( entity != null ) {
      return ResponseEntity.status(HttpStatus.SC_OK).body(new ResultMessage("200", "Success"));
    } else {
      return ResponseEntity.status(HttpStatus.SC_OK).body(new ResultMessage("999", "Failed"));
    }
  }
  
}
