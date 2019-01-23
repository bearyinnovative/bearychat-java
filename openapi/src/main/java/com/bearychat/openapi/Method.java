package com.bearychat.openapi;

public enum Method {
  GET("GET"),
  POST("POST"),
  DELETE("DELETE"),
  PATCH("PATCH");

  private final String method;

  Method(String method) {
    this.method = method;
  }

  public String getMethod() {
    return method;
  }
}
