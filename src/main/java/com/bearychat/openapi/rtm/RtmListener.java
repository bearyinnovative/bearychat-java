package com.bearychat.openapi.rtm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class RtmListener extends WebSocketListener {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final OkHttpClient httpClient;
  private final String wsHost;
  private final ObjectMapper mapper;
  private final RtmCallback callback;
  private WebSocket webSocket;

  private AtomicLong callId;

  public RtmListener(String wsHost, RtmCallback callback) {
    this.callId = new AtomicLong(0);
    this.wsHost = wsHost;
    this.httpClient = new OkHttpClient();
    this.mapper = new ObjectMapper();
    this.callback = callback;
  }

  public void run() {
    final var request = new Request.Builder()
            .url(this.wsHost)
            .build();
    webSocket = httpClient.newWebSocket(request, this);

    httpClient.dispatcher().executorService().shutdown();
  }

  public void send(RtmMessage message) throws JsonProcessingException {
    if (message.getCallId() == null) {
      message.setCallId(nextCallId());
    }

    final var data = mapper.writeValueAsString(message);
    this.webSocket.send(data);
  }

  private long nextCallId() {
    return this.callId.incrementAndGet();
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    logger.debug("rtm opened: {}");
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    logger.debug("rtm received message: {}", text);
    try {
      final var message = mapper.readValue(text, RtmMessage.class);
      callback.onMessage(this, message);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    logger.debug("rtm closing [ code = {}, reason = {} ]", code, reason);
  }

  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    logger.debug("rtm closed [ code = {}, reason = {} ]", code, reason);
    callback.onClose(this);
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    callback.onError(this);
    logger.error(t.getMessage(), t);
  }
}
