package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageAttachment {
  @JsonProperty("title")
  private String title;
  @JsonProperty("text")
  private String text;
  @JsonProperty("color")
  private String color;
  @JsonProperty("images")
  private MessageAttachmentImage[] images;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public MessageAttachmentImage[] getImages() {
    return images;
  }

  public void setImages(MessageAttachmentImage[] images) {
    this.images = images;
  }
}
