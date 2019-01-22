package com.bearychat.openapi.api;

import com.bearychat.openapi.models.P2p;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class P2pClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public P2pClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public P2p info(String p2pChannelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/p2p.info", Map.of(
            "p2p_channel_id", p2pChannelId
    ));
    return this.mapper.readValue(resp.body().string(), P2p.class);
  }

  public P2p[] list() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/p2p.list");
    return this.mapper.readValue(resp.body().string(), P2p[].class);
  }

  public P2p create(String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/p2p.create", Map.of(
            "user_id", userId
    ));
    return this.mapper.readValue(resp.body().string(), P2p.class);
  }
}
