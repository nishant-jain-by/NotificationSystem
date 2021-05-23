package com.target.service.source2;

import com.target.dto.NotificationRequest;
import com.target.dto.NotificationResponse;
import com.target.enums.EventEnum;
import com.target.service.INotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class Event2NotificationService extends BaseSource2Service implements INotificationService {

  /**
   * Predicate to decide the given event is supported by this class.
   *
   * @param eventType eventType from the request.
   * @return - returns true if the this class can support the event, false otherwise.
   */
  @Override
  public boolean supportsEvent(String eventType) {
    if(StringUtils.isEmpty(eventType)) {
      return false;
    }
    return EventEnum.EVENT2.toString().equalsIgnoreCase(eventType.toUpperCase());
  }

  @Override
  public Mono<NotificationResponse> notify(NotificationRequest request) {
    log.debug("HELLO ---- EVENT 2");
    return outputChannelService.notifyToOutputChannels(request);
/**        .onErrorResume(e -> Mono.just(
            NotificationResponse.builder()
                .status("Failure")
                .code(400)
                .information(e.getMessage())
                .build()));**/
  }
}
