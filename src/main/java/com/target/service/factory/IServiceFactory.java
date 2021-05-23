package com.target.service.factory;

import com.target.service.IsSupportedEvent;
import com.target.service.IsSupportedSourceSystem;
import java.util.List;

/**
 * Provides contract whether Implementing classes can support the given order source.
 */
public interface IServiceFactory<T extends IsSupportedSourceSystem & IsSupportedEvent> {

  /**
   * Get the service by sourceSystem.
   *
   * @param sourceSystem sourceSystem from the request
   * @param eventType eventType from the request
   * @param t {link List} of {@link T} list of generic class
   * @return - returns {@link T} Generic Service class
   */
  default T getService(String sourceSystem, String eventType, List<T> t) {
    return t
        .stream()
        .filter(service -> service.supportsSource(sourceSystem))
        .filter(service -> service.supportsEvent(eventType))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("sourceSystem or eventType is not supported"));
  }

}
