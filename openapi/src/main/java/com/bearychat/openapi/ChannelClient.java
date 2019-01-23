package com.bearychat.openapi;

import com.bearychat.openapi.models.Channel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class ChannelClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public ChannelClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public Channel info(String channelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, String.format("/v1/channel.info?channel_id=%s", channelId));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel[] list() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/channel.list");
    return this.mapper.readValue(resp.body().string(), Channel[].class);
  }

  public Channel create(String name, String topic, boolean isPrivate) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.create", Map.of(
            "name", name,
            "topic", topic,
            "private", isPrivate
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel archive(String channelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.archive", Map.of(
            "channel_id", channelId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel unarchive(String channelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.unarchive", Map.of(
            "channel_id", channelId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel join(String channelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.join", Map.of(
            "channel_id", channelId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel leave(String channelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.leave", Map.of(
            "channel_id", channelId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel invite(String channelId, String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.leave", Map.of(
            "channel_id", channelId,
            "invite_uid", userId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }

  public Channel kick(String channelId, String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/channel.kick", Map.of(
            "channel_id", channelId,
            "kick_uid", userId
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }
}
