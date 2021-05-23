package com.target.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

  @ExceptionHandler({Exception.class})
  public ResponseEntity handleParentEntityDoesNotExistException(ServerWebExchange request, Exception ex) {

    Map<String, Object> body = new HashMap<>();
    HttpStatus status = HttpStatus.BAD_REQUEST;
    body.put("error", status.name());
    body.put("message", ex.getMessage());
    body.put("status", status.value());
    request.getAttributes().put("original-exception", ex);

    return ResponseEntity.status(status).body(body);
  }
}
