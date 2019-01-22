package com.bearychat.openapi.examples;

import com.bearychat.openapi.api.OpenApiClient;

import java.io.IOException;
import java.util.Arrays;

public class ChannelOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    // list visible channels
    final var channels = client.channel().list();

    System.out.println("visible channels: ");
    Arrays.stream(channels).forEach(channel ->
            System.out.printf("- [%s] %s\n", channel.getId(), channel.getName())
    );

    // create new channel
    final var channel = client.channel().create("foo", "bar", false);
    System.out.println("create new channel: " + channel.getName());

    // archive channel
    client.channel().archive(channel.getId());

    // unarchive channel
    client.channel().unarchive(channel.getId());
  }
}
