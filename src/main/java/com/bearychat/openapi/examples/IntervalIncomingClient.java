package com.bearychat.openapi.examples;

import com.bearychat.openapi.Incoming;
import com.bearychat.openapi.IncomingClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class IntervalIncomingClient {
  public static void main(String[] args) throws MalformedURLException {
    final var incomingUrl = new URL ("YOUR_INCOMING_URL");
    final var client = new IncomingClient(incomingUrl);

    final var timer = new Timer();

    // print date every 5 seconds
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        final var incoming = new Incoming.Builder()
                .text(String.format("Hello, it is %s now", new Date().toString()))
                .build();
        try {
          client.send(incoming);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }, 0, 5000);
  }
}
