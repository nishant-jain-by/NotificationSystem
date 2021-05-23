package com.target.service;

import com.target.dto.NotificationRequest;
import com.target.dto.NotificationResponse;
import reactor.core.publisher.Mono;

public interface INotificationService extends IsSupportedSourceSystem, IsSupportedEvent {

  Mono<NotificationResponse> notify(NotificationRequest request);

}
