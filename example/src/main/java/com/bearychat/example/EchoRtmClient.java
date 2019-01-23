package com.bearychat.example;

import com.bearychat.rtm.RtmCallback;
import com.bearychat.rtm.RtmClient;
import com.bearychat.rtm.RtmListener;
import com.bearychat.rtm.RtmMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class EchoRtmClient {
  public static void main(String[] args) throws IOException {
    final var rtmToken = "YOUR_RTM_TOKEN";
    final var client = new RtmClient(
            "https://rtm.bearychat.com",
            rtmToken);

    final var preparation = client.prepare();

    final var currentUser = preparation.getResult().getUser();

    preparation.listen(new RtmCallback() {
      @Override
      public void onMessage(RtmListener listener, RtmMessage message) {
        if (!message.isChatMessage()) {
          return;
        }

        if (message.isMentionUser(currentUser)) {
          try {
            listener.send(message.refer("Hello, world"));
          } catch (JsonProcessingException e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onClose(RtmListener listener) {
      }

      @Override
      public void onError(RtmListener listener) {
      }
    }).run();
  }
}
