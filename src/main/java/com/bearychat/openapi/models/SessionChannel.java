package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionChannel {
  @JsonProperty("id")
  private String id;
  @JsonProperty("team_id")
  private String teamId;
  @JsonProperty("vchannel_id")
  private String vchannelId;
  @JsonProperty("type")
  private String type;
  @JsonProperty("name")
  private String name;
  @JsonProperty("is_member")
  private boolean isMember;
  @JsonProperty("is_active")
  private boolean isActive;
  @JsonProperty("latest_ts")
  private long latestTs;
  @JsonProperty("member_uids")
  private String[] memberUids;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public long getLatestTs() {
    return latestTs;
  }

  public void setLatestTs(long latestTs) {
    this.latestTs = latestTs;
  }

  public String[] getMemberUids() {
    return memberUids;
  }

  public void setMemberUids(String[] memberUids) {
    this.memberUids = memberUids;
  }
}
