package com.bearychat.openapi.examples;

import com.bearychat.openapi.api.OpenApiClient;
import com.bearychat.openapi.models.MessageAttachment;

import java.io.IOException;

public class MessageOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    // fetch an arbitrary channel
    final var channels = client.channel().list();

    final var channel = channels[0];

    // send an message
    final var message = client.message().create(channel.getVchannelId(), "hello, world", new MessageAttachment[]{});

    // update message
    client.message().updateText(channel.getVchannelId(), message.getKey(), "goodbye");
  }
}
