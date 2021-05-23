package com.target.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Message {

  @Valid
  @NotEmpty(message = "body can not be empty or NULL")
  private String body;

}
