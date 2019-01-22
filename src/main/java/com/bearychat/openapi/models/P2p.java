package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class P2p {
  @JsonProperty("id")
  private String id;
  @JsonProperty("team_id")
  private String teamId;
  @JsonProperty("vchannel_id")
  private String vchannelId;
  @JsonProperty("type")
  private String type;
  @JsonProperty("is_active")
  private boolean isActive;
  @JsonProperty("is_member")
  private boolean isMember;
  @JsonProperty("member_uids")
  private String[] memberUids;
  @JsonProperty("latest_ts")
  private long latestTs;

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

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public boolean isMember() {
    return isMember;
  }

  public void setMember(boolean member) {
    isMember = member;
  }

  public String[] getMemberUids() {
    return memberUids;
  }

  public void setMemberUids(String[] memberUids) {
    this.memberUids = memberUids;
  }

  public long getLatestTs() {
    return latestTs;
  }

  public void setLatestTs(long latestTs) {
    this.latestTs = latestTs;
  }
}
