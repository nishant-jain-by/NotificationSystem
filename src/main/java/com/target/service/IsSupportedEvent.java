package com.target.service;

/**
 * Provides contract whether Implementing classes can support the given event.
 */
public interface IsSupportedEvent {
  /**
   * Predicate to decide the given event is supported by this class.
   *
   * @param eventType eventType from the request.
   * @return - returns true if the this class can support the event, false otherwise.
   */
  boolean supportsEvent(String eventType);
}
