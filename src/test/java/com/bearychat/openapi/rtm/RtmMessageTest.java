package com.bearychat.openapi.rtm;

import com.bearychat.openapi.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RtmMessageTest {

  @Test
  void reply() {
  }

  @Test
  void refer() {
  }

  @Test
  void isP2p() {
  }

  @Test
  void isChatMessage() {
  }

  @Test
  void isFromUser() {
  }

  @Test
  void isMentionUser() {
    {
      final var message = new RtmMessage();
      message.setText("foobar");

      final var user = new User();
      user.setId("foobar");

      assertFalse(message.isMentionUser(user));
    }

    {
      final var message = new RtmMessage();
      final var user = new User();
      user.setId("=bw52O");

      assertFalse(message.isMentionUser(user));
    }

    {
      final var message = new RtmMessage();
      message.setText("hello, @<==bw52O=> ");

      final var user = new User();
      user.setId("=bw52O");

      assertTrue(message.isMentionUser(user));
    }

    {
      final var message = new RtmMessage();
      message.setText("hello, @<==bw52O=> and @<==bw52P=> ");

      final var user1 = new User();
      user1.setId("=bw52O");

      final var user2 = new User();
      user2.setId("=bw52P");

      final var user3 = new User();
      user3.setId("=bw52Q");

      assertTrue(message.isMentionUser(user1));
      assertTrue(message.isMentionUser(user2));
      assertFalse(message.isMentionUser(user3));
    }
  }
}