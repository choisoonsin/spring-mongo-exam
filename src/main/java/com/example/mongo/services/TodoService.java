package com.example.mongo.services;

import com.example.mongo.messages.ResultMessage;
import com.example.mongo.persistence.TodoEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface TodoService {

  @GetMapping(value = "/todo/{id}")
  @Operation(summary = "Todo API", description = "It provides todo data by id", method = "GET")
  @ApiResponses({
    @ApiResponse(
      responseCode = "200", 
      description = "성공", 
      content = { @Content(
        mediaType = "application/json", 
        schema = @Schema(implementation = Todo.class)        
      )}),
    @ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
    @ApiResponse(responseCode = "404", description = "요청한 데이터를 찾을 수 없습니다."),
    @ApiResponse(responseCode = "500", description = "서버 실행 오류") 
  })
  Todo selectUserTodo(@Parameter(description = "Todo는 고유한 id를 가진다. (User별로 고유한 값이 아니다.)", required = true, example = "1") @PathVariable("userId") int userId);

  @PostMapping(value = "/todo/{userId}", consumes = "application/json")
  ResponseEntity<ResultMessage> craeteUserTodo(
    @PathVariable("userId") int userId,
    @RequestBody TodoEntity params);
}