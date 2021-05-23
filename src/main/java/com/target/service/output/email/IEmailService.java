package com.target.service.output.email;

import com.target.dto.OutputChannelEnum;
import com.target.service.output.IChannelService;

public interface IEmailService extends IChannelService {

  @Override
  default boolean supportsChannel(OutputChannelEnum outputChannelEnum) {
    return OutputChannelEnum.EMAIL.toString().equalsIgnoreCase(outputChannelEnum.name().toUpperCase());
  }
}
