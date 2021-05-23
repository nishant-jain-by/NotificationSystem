package com.target.service.factory;

import com.target.service.INotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * class is responsible for providing service class for the given type of source system and type of event
 */
@Component
public class NotificationServiceFactory implements IServiceFactory<INotificationService> {

  @Autowired
  private List<INotificationService> notificationServices;

  /**
   * Get the service by sourceSystem.
   *
   * @param sourceSystem source from the request
   * @param eventType eventType from the request
   * @return - returns {@link INotificationService} designated to serve the notification related requests
   */
  public INotificationService getService(String sourceSystem, String eventType) {
    return getService(sourceSystem, eventType, notificationServices);
  }

}
