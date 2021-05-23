package com.target.service.output;

import com.target.dto.OutputChannelEnum;

public interface IChannelService {

  boolean supportsChannel(OutputChannelEnum outputChannelEnum);

  String process(String from, String to, String messageBody);

}
