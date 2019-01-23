package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageAttachmentImage {
  @JsonProperty("url")
  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
