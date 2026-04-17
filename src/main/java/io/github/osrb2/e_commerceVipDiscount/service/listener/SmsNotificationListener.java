package io.github.osrb2.e_commerceVipDiscount.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import io.github.osrb2.e_commerceVipDiscount.service.decorator.Notifier;
import io.github.osrb2.e_commerceVipDiscount.service.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SmsNotificationListener {

  private final Notifier notifier;

  @Async
  @EventListener
  public void onUserCreated(UserCreatedEvent event) {
    System.out.println("[SMS] Enviando sms para: " + event.getUser().getPhone());
    notifier.notify(event.getUser());
  }
}
