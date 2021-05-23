package com.target.service.source2;

import com.target.enums.SourceSystemEnum;
import com.target.service.IsSupportedSourceSystem;
import com.target.service.output.OutputChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class BaseSource2Service implements IsSupportedSourceSystem {

  @Autowired
  protected OutputChannelService outputChannelService;

  /**
   * Predicate to decide the given sourceSystem is supported by this class.
   *
   * @param sourceSystem source from the request.
   * @return - returns true if the this class can support the sourceSystem, false otherwise.
   */
  @Override
  public boolean supportsSource(String sourceSystem) {
    if(StringUtils.isEmpty(sourceSystem)) {
      return false;
    }
    return SourceSystemEnum.SOURCE2.toString().equalsIgnoreCase(sourceSystem.toUpperCase());
  }
}
