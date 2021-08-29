package com.example.mongo.servicesImpl;

import java.io.IOException;

import com.example.mongo.services.Todo;
import com.example.mongo.services.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoServiceImpl implements TodoService{

  @Override
  public Todo getProduct(int id) {

    HttpClient client = HttpClientBuilder.create().build();
    ObjectMapper mapper = new ObjectMapper();
    
    try {
      HttpResponse res = client.execute(new HttpGet("https://jsonplaceholder.typicode.com/todos/"+id));
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
  
}
