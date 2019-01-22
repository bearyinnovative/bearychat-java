package com.bearychat.openapi.rtm;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RtmClient extends WebSocketListener {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final String rtmHost;
  private final String rtmToken;
  private final OkHttpClient httpClient;
  private final ObjectMapper mapper;

  public RtmClient(String rtmHost, String rtmToken) {
    this.rtmHost = rtmHost;
    this.rtmToken = rtmToken;
    this.httpClient = new OkHttpClient();
    this.mapper = new ObjectMapper();
  }

  public RtmPreparation prepare() throws IOException {
    final var url = HttpUrl.parse(this.rtmHost)
            .resolve("/start")
            .newBuilder()
            .addQueryParameter("token", this.rtmToken)
            .build();
    final var request = new Request.Builder()
            .url(url)
            .post(RequestBody.create(null, ""))
            .build();
    final var resp = httpClient.newCall(request).execute();

    if (!resp.isSuccessful()) {
      throw new IOException(String.format("failed to start rtm [ status code = %d, body = %s ]", resp.code(), resp.body().string()));
    }
    return mapper.readValue(resp.body().string(), RtmPreparation.class);
  }
}
