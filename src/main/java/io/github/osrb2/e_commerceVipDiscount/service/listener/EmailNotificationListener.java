package io.github.osrb2.e_commerceVipDiscount.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import io.github.osrb2.e_commerceVipDiscount.service.decorator.Notifier;
import io.github.osrb2.e_commerceVipDiscount.service.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailNotificationListener {

  private final Notifier notifier;

  @Async
  @EventListener
  public void onUserCreated(UserCreatedEvent event) {
    System.out.println("[EMAIL] Enviando email para: " + event.getUser().getEmail());
    notifier.notify(event.getUser());
  }
}
