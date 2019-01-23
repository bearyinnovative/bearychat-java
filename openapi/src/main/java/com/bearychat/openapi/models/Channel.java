package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {
  @JsonProperty("id")
  private String id;
  @JsonProperty("team_id")
  private String teamId;
  @JsonProperty("vchannel_id")
  private String vchannelId;
  @JsonProperty("uid")
  private String userId;
  @JsonProperty("name")
  private String name;
  @JsonProperty("topic")
  private String topic;
  @JsonProperty("type")
  private String type;
  @JsonProperty("private")
  private boolean isPrivate;
  @JsonProperty("general")
  private boolean isGeneral;
  @JsonProperty("is_member")
  private boolean isMember;
  @JsonProperty("is_active")
  private boolean isActive;
  @JsonProperty("member_uids")
  private String[] memberUids;
  @JsonProperty("latest_ts")
  private Long latestTs;

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

  public String getVchannelId() {
    return vchannelId;
  }

  public void setVchannelId(String vchannelId) {
    this.vchannelId = vchannelId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isPrivate() {
    return isPrivate;
  }

  public void setPrivate(boolean aPrivate) {
    isPrivate = aPrivate;
  }

  public boolean isGeneral() {
    return isGeneral;
  }

  public void setGeneral(boolean general) {
    isGeneral = general;
  }

  public boolean isMember() {
    return isMember;
  }

  public void setMember(boolean member) {
    isMember = member;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String[] getMemberUids() {
    return memberUids;
  }

  public void setMemberUids(String[] memberUids) {
    this.memberUids = memberUids;
  }

  public Long getLatestTs() {
    return latestTs;
  }

  public void setLatestTs(Long latestTs) {
    this.latestTs = latestTs;
  }
}
