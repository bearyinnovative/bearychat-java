package com.bearychat.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.net.URL;

public class IncomingClient {
  private final URL url;
  private final OkHttpClient httpClient;
  private final ObjectMapper mapper;

  public IncomingClient(URL url) {
    this(new OkHttpClient(), url);
  }

  public IncomingClient(OkHttpClient httpClient, URL url) {
    this(httpClient, url, new ObjectMapper());
  }


  public IncomingClient(OkHttpClient httpClient, URL url, ObjectMapper mapper) {
    this.httpClient = httpClient;
    this.url = url;
    this.mapper = mapper;
  }

  public Response send(Incoming incoming) throws IOException {
    final var data = mapper.writeValueAsString(incoming);

    final var body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), data);
    final var request = new Request.Builder()
            .url(this.url)
            .post(body)
            .build();

    final var resp = this.httpClient.newCall(request).execute();

    return resp;
  }
}
