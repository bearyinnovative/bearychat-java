package com.bearychat.openapi.rtm;

import com.bearychat.openapi.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtmMessage {
  private static final Pattern mentionUidsPattern = Pattern.compile("@<=(=[A-Za-z0-9]+)=> ");

  @JsonProperty("call_id")
  private Long callId;
  @JsonProperty("key")
  private String key;
  @JsonProperty("refer_key")
  private String referKey;
  @JsonProperty("type")
  private String type;
  @JsonProperty("text")
  private String text;
  @JsonProperty("vchannel_id")
  private String vchannelId;
  @JsonProperty("uid")
  private String fromUid;
  @JsonProperty("to_uid")
  private String toUid;
  @JsonProperty("channel_id")
  private String channelId;

  private Set<String> mentionUids;

  public Long getCallId() {
    return callId;
  }

  public void setCallId(Long callId) {
    this.callId = callId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    if (text != null && !text.isBlank()) {
      final var matcher = mentionUidsPattern.matcher(text);
      this.mentionUids = matcher.results()
              .map(result -> result.group(1))
              .collect(Collectors.toSet());
    }
    this.text = text;
  }

  public String getVchannelId() {
    return vchannelId;
  }

  public void setVchannelId(String vchannelId) {
    this.vchannelId = vchannelId;
  }

  public String getFromUid() {
    return fromUid;
  }

  public void setFromUid(String fromUid) {
    this.fromUid = fromUid;
  }

  public String getReferKey() {
    return referKey;
  }

  public void setReferKey(String referKey) {
    this.referKey = referKey;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getToUid() {
    return toUid;
  }

  public void setToUid(String toUid) {
    this.toUid = toUid;
  }

  public String getChannelId() {
    return channelId;
  }

  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }

  /**
   * Reply a message
   **/
  public RtmMessage reply(String text) {
    final var reply = new RtmMessage();
    reply.setText(text);
    reply.setVchannelId(this.getVchannelId());
    if (this.isP2p()) {
      reply.setType(RtmMessageType.P2P_MESSAGE);
      reply.setToUid(this.getFromUid());
    } else {
      reply.setType(RtmMessageType.CHANNEL_MESSAGE);
      reply.setChannelId(this.getChannelId());
    }
    return reply;
  }

  /**
   * Refer a message
   **/
  public RtmMessage refer(String text) {
    final var refer = this.reply(text);
    refer.setReferKey(this.getKey());

    return refer;
  }

  public boolean isP2p() {
    return this.getType().equals(RtmMessageType.P2P_MESSAGE) || this.getType().equals(RtmMessageType.P2P_TYPING);
  }

  public boolean isChatMessage() {
    return this.getType().equals(RtmMessageType.CHANNEL_MESSAGE) || this.getType().equals(RtmMessageType.P2P_MESSAGE);
  }

  public boolean isFromUser(User user) {
    return this.getFromUid().equals(user.getId());
  }

  public boolean isMentionUser(User user) {
    return this.mentionUids != null && this.mentionUids.contains(user.getId());
  }
}
