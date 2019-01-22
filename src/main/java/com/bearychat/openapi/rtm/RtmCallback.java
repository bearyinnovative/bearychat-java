package com.bearychat.openapi.rtm;

public interface RtmCallback {
  void onMessage(RtmListener listener, RtmMessage message);
  void onClose(RtmListener listener);
  void onError(RtmListener listener);
}
