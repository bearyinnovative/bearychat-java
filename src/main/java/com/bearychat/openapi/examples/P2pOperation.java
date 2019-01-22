package com.bearychat.openapi.examples;

import com.bearychat.openapi.api.OpenApiClient;

import java.io.IOException;
import java.util.Arrays;

public class P2pOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    // list all p2p channels
    final var p2p_channels = client.p2p().list();

    System.out.println("visible p2p channels: ");
    Arrays.stream(p2p_channels).forEach(p2p ->
            System.out.printf("- [%s] (%s, %s)\n", p2p.getId(), p2p.getMemberUids()[0], p2p.getMemberUids()[1])
    );
  }
}
