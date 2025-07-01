package com.example.Restaurant.Management.System.Dto.Response;

public class ApiResponse<T> {
  private T data;
  private String status;
  private int statusCode;
  private String message;

  public ApiResponse() {
  }

  public ApiResponse(T data, String status, int statusCode, String message) {
    this.data = data;
    this.status = status;
    this.statusCode = statusCode;
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}