package com.bearychat.openapi.examples;

import com.bearychat.openapi.api.OpenApiClient;

import java.io.IOException;
import java.util.Arrays;

public class UserOperation {
  public static void main(String[] args) throws IOException {
    final var apiToken = "YOUR_TOKEN";
    final var client = new OpenApiClient(
            "https://api.bearychat.com",
            apiToken
    );

    // get current user info
    final var me = client.user().me();
    System.out.printf("current user name: %s, id: %s\n", me.getName(), me.getId());

    // list all users
    System.out.println("users:");
    final var users = client.user().list();
    Arrays.stream(users).forEach(user ->
            System.out.printf("- user: [ id: %s, name: %s] \n", user.getId(), user.getName()));
  }
}
