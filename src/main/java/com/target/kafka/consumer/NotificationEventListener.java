package com.target.kafka.consumer;

import com.target.dto.KafkaNotificationRequest;
import com.target.kafka.KafkaRequestToRequestMapper;
import com.target.service.factory.NotificationServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("kafka-integrator")
@Component
public class NotificationEventListener {

  private static final String TOPIC_NAME = "topic-name";
  private static final String GROUP_ID = "nj-group";

  @Autowired
  private NotificationServiceFactory notificationServiceFactory;

  @Autowired
  private KafkaRequestToRequestMapper mapper;

  @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
  public void listenGroupFoo(KafkaNotificationRequest request) {
    log.debug("Received Message in group {} : {}", GROUP_ID, request);
    //process it further by calling
    notificationServiceFactory.getService(request.getSource(), request.getEventType())
        .notify(mapper.map(request))
        .subscribe();
  }

}
