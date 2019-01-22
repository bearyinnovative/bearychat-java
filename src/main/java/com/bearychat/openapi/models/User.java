package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
  @JsonProperty("id")
  private String id;
  @JsonProperty("team_id")
  private String teamId;
  @JsonProperty("inactive")
  private boolean isInactive;
  @JsonProperty("role")
  private String role;
  @JsonProperty("type")
  private String type;
  @JsonProperty("owner_id")
  private String ownerId;
  @JsonProperty("email")
  private String email;
  @JsonProperty("mobile")
  private String mobile;
  @JsonProperty("name")
  private String name;
  @JsonProperty("full_name")
  private String fullname;
  @JsonProperty("token")
  private String token;
  @JsonProperty("email_verified")
  private boolean isEmailVerified;
  @JsonProperty("mobile_verified")
  private boolean isMobileVerified;
  @JsonProperty("has_name_modified")
  private boolean hasNameModified;
  @JsonProperty("created")
  private Date created;
  @JsonProperty("updated")
  private Date updated;
  @JsonProperty("avatars")
  private Avatar avatar;
  @JsonProperty("avatar_url")
  private String avatarUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public boolean isInactive() {
    return isInactive;
  }

  public void setInactive(boolean inactive) {
    isInactive = inactive;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public boolean isEmailVerified() {
    return isEmailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
    isEmailVerified = emailVerified;
  }

  public boolean isMobileVerified() {
    return isMobileVerified;
  }

  public void setMobileVerified(boolean mobileVerified) {
    isMobileVerified = mobileVerified;
  }

  public boolean isHasNameModified() {
    return hasNameModified;
  }

  public void setHasNameModified(boolean hasNameModified) {
    this.hasNameModified = hasNameModified;
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

  public Avatar getAvatar() {
    return avatar;
  }

  public void setAvatar(Avatar avatar) {
    this.avatar = avatar;
  }

  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public class Avatar {
    @JsonProperty("small")
    private String small;
    @JsonProperty("medium")
    private String medium;
    @JsonProperty("large")
    private String large;

    public String getSmall() {
      return small;
    }

    public void setSmall(String small) {
      this.small = small;
    }

    public String getMedium() {
      return medium;
    }

    public void setMedium(String medium) {
      this.medium = medium;
    }

    public String getLarge() {
      return large;
    }

    public void setLarge(String large) {
      this.large = large;
    }
  }
}
