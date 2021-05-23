package com.target.service;

/**
 * Provides contract whether Implementing classes can support the given order source.
 */
public interface IsSupportedSourceSystem {

  /**
   * Predicate to decide the given sourceSystem is supported by this class.
   *
   * @param sourceSystem source from the request.
   * @return - returns true if the this class can support the sourceSystem, false otherwise.
   */
  boolean supportsSource(String sourceSystem);

}
