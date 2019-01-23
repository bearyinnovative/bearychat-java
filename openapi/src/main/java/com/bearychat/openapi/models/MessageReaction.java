package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageReaction {
  @JsonProperty("reaction")
  private String reaction;
  @JsonProperty("uids")
  private String[] uids;
  @JsonProperty("created_ts")
  private long createdTs;

  public String getReaction() {
    return reaction;
  }

  public void setReaction(String reaction) {
    this.reaction = reaction;
  }

  public String[] getUids() {
    return uids;
  }

  public void setUids(String[] uids) {
    this.uids = uids;
  }

  public long getCreatedTs() {
    return createdTs;
  }

  public void setCreatedTs(long createdTs) {
    this.createdTs = createdTs;
  }
}
