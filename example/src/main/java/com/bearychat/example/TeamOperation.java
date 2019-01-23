package com.bearychat.example;

import com.bearychat.openapi.OpenApiClient;

import java.io.IOException;

public class TeamOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    // show current team info
    final var team = client.team().info();

    System.out.printf("Team { id: %s, subdomain: %s, name: %s}\n",
            team.getId(), team.getSubdomain(), team.getName());
  }
}
