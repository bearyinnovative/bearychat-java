package com.bearychat.rtm;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.TimerTask;

public class RtmKeepAlive extends TimerTask {
  private final RtmListener listener;

  public RtmKeepAlive(RtmListener listener) {
    this.listener = listener;
  }

  @Override
  public void run() {
    final var ping = new RtmMessage();
    ping.setType(RtmMessageType.PING);
    try {
      this.listener.send(ping);
    } catch (JsonProcessingException e) {
      this.cancel();
    }
  }
}
