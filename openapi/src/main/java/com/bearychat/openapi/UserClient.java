package com.bearychat.openapi;

import com.bearychat.openapi.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class UserClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public UserClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public User me() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/user.me");
    return this.mapper.readValue(resp.body().string(), User.class);
  }

  public User updateMe(String name, String fullname) throws IOException {
    final var resp = this.apiClient.newRequest(Method.PATCH, "/v1/user.update_me", Map.of(
            "name", name,
            "full_name", fullname
    ));
    return this.mapper.readValue(resp.body().string(), User.class);
  }

  public User info(String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, String.format("/v1/user.info?user_id=%s", userId));
    return this.mapper.readValue(resp.body().string(), User.class);
  }

  public User[] list() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/user.list");
    return this.mapper.readValue(resp.body().string(), User[].class);
  }
}
