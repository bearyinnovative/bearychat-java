package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

public class Message {
  @JsonProperty("id")
  private String id;
  @JsonProperty("team_id")
  private String teamId;
  @JsonProperty("uid")
  private String uid;
  @JsonProperty("robot_id")
  private String robotId;
  @JsonProperty("pin_id")
  private String pinId;
  @JsonProperty("star_id")
  private String starId;

  @JsonProperty("key")
  private String key;
  @JsonProperty("refer_key")
  private String referKey;
  @JsonProperty("text")
  private String text;
  @JsonProperty("text_i18n")
  private Map<String, String> textI18n;
  @JsonProperty("subtype")
  private String subtype;
  @JsonProperty("reactions")
  private MessageReaction[] reactions;
  @JsonProperty("attachments")
  private MessageAttachment[] attachments;

  @JsonProperty("edited")
  private boolean isEdited;
  @JsonProperty("disable_markdown")
  private boolean isDisableMarkdown;

  @JsonProperty("created")
  private Date created;
  @JsonProperty("updated")
  private Date updated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getRobotId() {
    return robotId;
  }

  public void setRobotId(String robotId) {
    this.robotId = robotId;
  }

  public String getPinId() {
    return pinId;
  }

  public void setPinId(String pinId) {
    this.pinId = pinId;
  }

  public String getStarId() {
    return starId;
  }

  public void setStarId(String starId) {
    this.starId = starId;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getReferKey() {
    return referKey;
  }

  public void setReferKey(String referKey) {
    this.referKey = referKey;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Map<String, String> getTextI18n() {
    return textI18n;
  }

  public void setTextI18n(Map<String, String> textI18n) {
    this.textI18n = textI18n;
  }

  public String getSubtype() {
    return subtype;
  }

  public void setSubtype(String subtype) {
    this.subtype = subtype;
  }

  public MessageReaction[] getReactions() {
    return reactions;
  }

  public void setReactions(MessageReaction[] reactions) {
    this.reactions = reactions;
  }

  public boolean isEdited() {
    return isEdited;
  }

  public void setEdited(boolean edited) {
    isEdited = edited;
  }

  public boolean isDisableMarkdown() {
    return isDisableMarkdown;
  }

  public void setDisableMarkdown(boolean disableMarkdown) {
    isDisableMarkdown = disableMarkdown;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public MessageAttachment[] getAttachments() {
    return attachments;
  }

  public void setAttachments(MessageAttachment[] attachments) {
    this.attachments = attachments;
  }
}
