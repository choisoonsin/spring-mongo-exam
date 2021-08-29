package com.example.mongo.services;

public class Todo {
  
  private int userId;
  private int id;
  private String title;
  private boolean completed;
  
  public Todo() {}

  public Todo(int userId, int id, String title, boolean completed) {
    this.setUserId(userId);
    this.setId(id);
    this.setTitle(title);
    this.setCompleted(completed);
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  } 

}
