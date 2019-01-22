package com.bearychat.openapi.api;

import com.bearychat.openapi.models.Message;
import com.bearychat.openapi.models.MessageAttachment;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class MessageClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OpenApiClient apiClient;
  private final ObjectMapper mapper;

  public MessageClient(OpenApiClient apiClient, ObjectMapper objectMapper) {
    this.apiClient = apiClient;
    this.mapper = objectMapper;
  }

  public Message info(String vchannelId, String key) throws IOException {
    final var endpoint = String.format("/v1/message.info?vchannel_id=%s&message_key=%s", vchannelId, key);
    final var resp = this.apiClient.newRequest(Method.GET, endpoint);
    return this.mapper.readValue(resp.body().string(), Message.class);
  }

  public Message updateText(String vchannelId, String key, String text) throws IOException {
    final var endpoint = "/v1/message.update_text";
    final var resp = this.apiClient.newRequest(Method.PATCH, endpoint, Map.of(
            "vchannel_id", vchannelId,
            "message_key", key,
            "text", text
    ));
    return this.mapper.readValue(resp.body().string(), Message.class);
  }

  public Message delete(String vchannelId, String key) throws IOException {
    final var endpoint = "/v1/message.delete";
    final var resp = this.apiClient.newRequest(Method.POST, endpoint, Map.of(
            "vchannel_id", vchannelId,
            "message_key", key
    ));
    return this.mapper.readValue(resp.body().string(), Message.class);
  }

  public Message create(String vchannelId, String text, MessageAttachment[] attachments) throws IOException {
    final var endpoint = "/v1/message.create";
    final var resp = this.apiClient.newRequest(Method.POST, endpoint, Map.of(
            "vchannel_id", vchannelId,
            "text", text,
            "attachments", attachments
    ));
    return this.mapper.readValue(resp.body().string(), Message.class);
  }

  public Message forward(String vchannelId, String key, String toVchannelId) throws IOException {
    final var endpoint = "/v1/message.forward";
    final var resp = this.apiClient.newRequest(Method.POST, endpoint, Map.of(
            "vchannel_id", vchannelId,
            "message_key", key,
            "to_vchannel_id", toVchannelId
    ));
    return this.mapper.readValue(resp.body().string(), Message.class);
  }
}
