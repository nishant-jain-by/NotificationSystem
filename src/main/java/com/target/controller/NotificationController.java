package com.target.controller;

import com.target.dto.NotificationRequest;
import com.target.dto.NotificationResponse;
import com.target.service.factory.NotificationServiceFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = NotificationController.ENDPOINT)
public class NotificationController {

  public static final String ENDPOINT = "/notification";

  @Autowired
  private NotificationServiceFactory notificationServiceFactory;

  @PostMapping
  public Mono<ResponseEntity<NotificationResponse>> notify(
      @Valid @RequestBody NotificationRequest request,
      @RequestHeader(required = true) String source) {
    /* Take the request and extract Output Profile Array, source, LastState, NewState, Subject body */

    return notificationServiceFactory.getService(source, request.getEventType())
        .notify(request)
        .transform(response -> response
            .map(entity-> ResponseEntity.ok().body(entity))
            .defaultIfEmpty(ResponseEntity.noContent().build()));

  }

}
