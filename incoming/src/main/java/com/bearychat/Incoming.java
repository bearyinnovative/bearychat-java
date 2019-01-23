package com.bearychat;

public class Incoming {
  private String text;
  private String notification;
  private boolean markdown;
  private String channel;
  private String user;
  private IncomingAttachment[] attachments;

  public Incoming(String text, String notification, boolean markdown, String channel, String user, IncomingAttachment[] attachments) {
    this.text = text;
    this.notification = notification;
    this.markdown = markdown;
    this.channel = channel;
    this.user = user;
    this.attachments = attachments;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getNotification() {
    return notification;
  }

  public void setNotification(String notification) {
    this.notification = notification;
  }

  public boolean isMarkdown() {
    return markdown;
  }

  public void setMarkdown(boolean markdown) {
    this.markdown = markdown;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public IncomingAttachment[] getAttachments() {
    return attachments;
  }

  public void setAttachments(IncomingAttachment[] attachments) {
    this.attachments = attachments;
  }

  public static class Builder {
    private String text;
    private String notification;
    private boolean markdown;
    private String channel;
    private String user;
    private IncomingAttachment[] attachments;

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder notification(String notification) {
      this.notification = notification;
      return this;
    }

    public Builder markdown(boolean markdown) {
      this.markdown = markdown;
      return this;
    }

    public Builder channel(String channel) {
      this.channel = channel;
      return this;
    }

    public Builder user(String user) {
      this.user = user;
      return this;
    }

    public Builder attachments(IncomingAttachment[] attachments) {
      this.attachments = attachments;
      return this;
    }

    public Incoming build() {
      return new Incoming(text, notification, markdown, channel, user, attachments);
    }
  }
}
