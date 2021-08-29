package com.example.mongo.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class TodoEntity {

  @Id
  private String id;

  @Version
  private Integer version;

  private int userId;
  private String title;
  private boolean completed;
  
  public TodoEntity() {}
  
  public TodoEntity(int userId, String title, boolean complete) {
    this.setUserId(userId);
    this.setTitle(title);
    this.setCompleted(complete);
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
  
  public String getId() {
    return this.id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

}
