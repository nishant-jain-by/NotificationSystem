package com.target.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequest {

  @Valid
  @NotEmpty(message = "eventType can not be empty or NULL")
  private String eventType;

  @Valid
  @NotEmpty(message = "from can not be empty or NULL")
  private String from;

  @Valid
  @NotEmpty(message = "to can not be empty or NULL")
  private String to;

  @Valid
  @NotNull(message = "Message can not be empty or NULL")
  private Message message;

  @Valid
  @NotNull(message = "outputChannels can not be empty or NULL")
  private List<@Valid OutputChannelEnum> outputChannels;

  private State prevState;

  private State newState;

}
