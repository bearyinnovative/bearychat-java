package com.bearychat.openapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OpenApiClient {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final String host;
  private final OkHttpClient httpClient;
  private final ObjectMapper mapper;
  private final String token;

  private final ChannelClient channelClient;
  private final UserClient userClient;
  private final MessageClient messageClient;
  private final SessionChannelClient sessionChannelClient;

  public OpenApiClient(String host, String token) {
    this(new OkHttpClient(), host, token);
  }

  public OpenApiClient(OkHttpClient httpClient, String host, String token) {
    this.host = host;
    this.httpClient = httpClient;
    this.mapper = new ObjectMapper();
    this.token = token;

    this.channelClient = new ChannelClient(this, this.mapper);
    this.userClient = new UserClient(this, this.mapper);
    this.messageClient = new MessageClient(this, this.mapper);
    this.sessionChannelClient = new SessionChannelClient(this,this.mapper);
  }

  public ChannelClient channel() {
    return this.channelClient;
  }

  public UserClient user() {
    return this.userClient;
  }

  public MessageClient message() {
    return this.messageClient;
  }

  public SessionChannelClient sessionChannel() {
    return this.sessionChannelClient;
  }

  public Response newRequest(Method method, String endpoint, String data) throws IOException {
    final var url = HttpUrl
            .parse(this.host)
            .resolve(endpoint)
            .newBuilder()
            .addQueryParameter("token", this.token)
            .build();

    logger.debug("Open Api Client is requesting { url: {}, method: {} }", url, method);

    RequestBody body = null;
    if (data != null) {
      body = RequestBody
              .create(MediaType.get("application/json; charset=utf-8"), data);
    }

    final var requestBuilder = new Request.Builder()
            .url(url);
    switch (method) {
      case GET:
        requestBuilder.get();
        break;
      case POST:
        requestBuilder.post(body);
        break;
      case PATCH:
        requestBuilder.patch(body);
        break;
      case DELETE:
        requestBuilder.delete();
        break;
    }
    final var request = requestBuilder.build();
    final var resp = this.httpClient.newCall(request).execute();

    if (!resp.isSuccessful()) {
      throw new IOException(String.format("failed to request open api [status code = %d, body = %s]", resp.code(), resp.body().string()));
    }

    return resp;
  }


  public Response newRequest(Method method, String endpoint) throws IOException {
    return this.newRequest(method, endpoint, null);
  }

  public Response newRequest(Method method, String endpoint, Object data) throws IOException {
    final var json = this.mapper.writeValueAsString(data);
    return this.newRequest(method, endpoint, json);
  }
}
