package com.bearychat.openapi;

public class IncomingAttachment {
  private String title;
  private String text;
  private String color;
  private Image[] images;

  public IncomingAttachment(String title, String text, String color, Image[] images) {
    this.title = title;
    this.text = text;
    this.color = color;
    this.images = images;
  }

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

  public Image[] getImages() {
    return images;
  }

  public void setImages(Image[] images) {
    this.images = images;
  }

  public class Image {
    private String url;
  }

  public static class Builder {
    private String title;
    private String text;
    private String color;
    private IncomingAttachment.Image[] images;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder color(String color) {
      this.color = color;
      return this;
    }

    public Builder images(IncomingAttachment.Image[] images) {
      this.images = images;
      return this;
    }

    public IncomingAttachment build() {
      return new IncomingAttachment(title, text, color, images);
    }
  }
}
