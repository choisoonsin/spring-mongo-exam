package com.example.mongo.messages;

public class ResultMessage {

  private String resultCode;
  private String resultMessage;
  private String createCnt;
  private String updasteCnt;
  private String deleteCnt;
  
  public ResultMessage(String resultCode, String resultMessage) {
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
  }

  public String getDeleteCnt() {
    return deleteCnt;
  }
  public String getResultCode() {
    return resultCode;
  }
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }
  public void setDeleteCnt(String deleteCnt) {
    this.deleteCnt = deleteCnt;
  }
  public String getUpdasteCnt() {
    return updasteCnt;
  }
  public void setUpdasteCnt(String updasteCnt) {
    this.updasteCnt = updasteCnt;
  }
  public String getCreateCnt() {
    return createCnt;
  }
  public void setCreateCnt(String createCnt) {
    this.createCnt = createCnt;
  }
  public String getResultMessage() {
    return resultMessage;
  }
  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }

}