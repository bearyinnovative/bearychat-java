Real-Time Message Example
====

## Echo mentioned message

[source](/src/main/java/com/bearychat/openapi/examples/EchoRtmClient.java)

```java
package com.bearychat.openapi.examples;

import com.bearychat.openapi.rtm.RtmCallback;
import com.bearychat.openapi.rtm.RtmClient;
import com.bearychat.openapi.rtm.RtmListener;
import com.bearychat.openapi.rtm.RtmMessage;
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
```
