package com.bearychat.openapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Team {
  @JsonProperty("id")
  private String id;
  @JsonProperty("subdomain")
  private String subdomain;
  @JsonProperty("name")
  private String name;
  @JsonProperty("email_domain")
  private String emailDomain;
  @JsonProperty("logo_url")
  private String logoUrl;
  @JsonProperty("description")
  private String description;
  @JsonProperty("plan")
  private String plan;
  @JsonProperty("created")
  private Date created;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public String getSubdomain() {
    return subdomain;
  }

  public void setSubdomain(String subdomain) {
    this.subdomain = subdomain;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailDomain() {
    return emailDomain;
  }

  public void setEmailDomain(String emailDomain) {
    this.emailDomain = emailDomain;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}
