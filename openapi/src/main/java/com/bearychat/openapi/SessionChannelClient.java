package com.bearychat.openapi;

import com.bearychat.openapi.models.SessionChannel;
import com.bearychat.openapi.models.Channel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class SessionChannelClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public SessionChannelClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public SessionChannel info(String sessionChannelId) throws IOException {
    final var endpoint = String.format("/v1/session_channel.info?session_channel_id=%s", sessionChannelId);
    final var resp = this.apiClient.newRequest(Method.GET, endpoint);
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel[] list() throws IOException {
    final var resp = this.apiClient.newRequest(Method.GET, "/v1/session_channel.list");
    return this.mapper.readValue(resp.body().string(), SessionChannel[].class);
  }

  public SessionChannel create(String name, String[] memberUids) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.create", Map.of(
            "name", name,
            "member_uids", memberUids
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel archive(String sessionChannelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.archive", Map.of(
            "session_channel_id", sessionChannelId
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel join(String sessionChannelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.join", Map.of(
            "session_channel_id", sessionChannelId
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel leave(String sessionChannelId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.leave", Map.of(
            "session_channel_id", sessionChannelId
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel invite(String sessionChannelId, String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.leave", Map.of(
            "session_channel_id", sessionChannelId,
            "invite_uid", userId
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public SessionChannel kick(String sessionChannelId, String userId) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.kick", Map.of(
            "session_channel_id", sessionChannelId,
            "kick_uid", userId
    ));
    return this.mapper.readValue(resp.body().string(), SessionChannel.class);
  }

  public Channel convertToChannel(String sessionChannelId, String name, boolean isPrivate) throws IOException {
    final var resp = this.apiClient.newRequest(Method.POST, "/v1/session_channel.convert_to_channel", Map.of(
            "session_channel_id", sessionChannelId,
            "name", name,
            "private", isPrivate
    ));
    return this.mapper.readValue(resp.body().string(), Channel.class);
  }
}
