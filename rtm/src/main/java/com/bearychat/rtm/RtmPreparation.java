package com.bearychat.rtm;

import com.bearychat.openapi.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Timer;

public class RtmPreparation {
  @JsonProperty("code")
  private long code;
  @JsonProperty("error")
  private String error;
  @JsonProperty("result")
  private Result result;

  public RtmListener listen(RtmCallback callback) {
    final var listener = new RtmListener(this.result.getWsHost(), callback);
    final var keepAlive = new RtmKeepAlive(listener);

    final var timer = new Timer();
    timer.schedule(keepAlive, 0, 10000);
    return listener;
  }

  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public static class Result {
    @JsonProperty("ws_host")
    private String wsHost;

    @JsonProperty("user")
    private User user;

    public String getWsHost() {
      return wsHost;
    }

    public void setWsHost(String wsHost) {
      this.wsHost = wsHost;
    }

    public User getUser() {
      return user;
    }

    public void setUser(User user) {
      this.user = user;
    }
  }
}
