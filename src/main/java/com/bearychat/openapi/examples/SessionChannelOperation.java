package com.bearychat.openapi.examples;

import com.bearychat.openapi.api.OpenApiClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SessionChannelOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    final var users = client.user().list();

    // list visible channels
    final var sessionChannels = client.sessionChannel().list();

    System.out.println("visible session channels: ");
    Arrays.stream(sessionChannels).forEach(sessionChannel ->
            System.out.printf("- [%s] %s\n", sessionChannel.getId(), sessionChannel.getName())
    );

    final var userIds = Arrays.stream(users)
            .map(user -> user.getId())
            .collect(Collectors.toSet())
            .toArray(new String[]{});
    // create new session channel
    final var sessionChannel = client.sessionChannel().create("foo", userIds);
    System.out.println("create new session channel: " + sessionChannel.getName());

    // convert to channel
    client.sessionChannel().convertToChannel(sessionChannel.getId(), "foo_channel", true);
  }
}
