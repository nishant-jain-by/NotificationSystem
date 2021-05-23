package com.target.service.output.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("mock")
@Service
public class MockEmailService implements IEmailService {

  @Override
  public String process(String from, String to, String messageBody) {
    log.info("Successfully able to send message from: {} to: {} and message: {}", from, to, messageBody);
    return new StringBuilder("[MockEmailService] Successfully able to send message from " + from + " to: " + to +
        " and message: " + messageBody).toString();
  }
}
