package com.target.service.output;

import com.target.dto.NotificationRequest;
import com.target.dto.NotificationResponse;
import com.target.exceptions.NotSupportedOutputChannelException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class OutputChannelService {

  @Autowired(required = false)
  List<IChannelService> channelServices;

  public Mono<NotificationResponse> notifyToOutputChannels(NotificationRequest request) {
    if(null == channelServices || channelServices.isEmpty()) {
      log.error("No Channel Service implmented for the requested output channels");
      return Mono.error(new NotSupportedOutputChannelException("No Channel Service implmented for the requested output channels"));
    }
    List<String> outputMsgs = request.getOutputChannels()
        .stream()
        .map(outputChannelEnum -> {

          return channelServices.stream()
              .filter(service -> service.supportsChannel(outputChannelEnum))
              .map(channelService -> channelService.process(request.getFrom(), request.getTo(), request.getMessage().getBody()))
              .findFirst()
              .orElse(null);
        }).collect(Collectors.toList());
    return Mono.just(
        NotificationResponse.builder()
            .message(outputMsgs.toString())
            .build());
  }

}
