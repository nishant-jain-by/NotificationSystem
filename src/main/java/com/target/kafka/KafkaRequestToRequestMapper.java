package com.target.kafka;

import com.target.dto.KafkaNotificationRequest;
import com.target.dto.NotificationRequest;
import org.springframework.stereotype.Component;

@Component
public class KafkaRequestToRequestMapper {

  public NotificationRequest map(KafkaNotificationRequest request) {
    return NotificationRequest.builder()
        .eventType(request.getEventType())
        .from(request.getFrom())
        .to(request.getTo())
        .message(request.getMessage())
        .outputChannels(request.getOutputChannels())
        .prevState(request.getPrevState())
        .newState(request.getNewState())
        .build();
  }
}
