package com.bearychat.openapi;

import com.bearychat.openapi.models.Team;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TeamClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public TeamClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public Team info() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/team.info");
    return this.mapper.readValue(resp.body().string(), Team.class);
  }
}
