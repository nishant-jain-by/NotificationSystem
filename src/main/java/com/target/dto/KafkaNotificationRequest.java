package com.target.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class KafkaNotificationRequest {

  private String source;

  private String eventType;

  private String from;

  private String to;

  private Message message;

  private List<OutputChannelEnum> outputChannels;

  private State prevState;

  private State newState;

}
