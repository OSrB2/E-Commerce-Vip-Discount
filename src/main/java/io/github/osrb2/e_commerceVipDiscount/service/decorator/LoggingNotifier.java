package io.github.osrb2.e_commerceVipDiscount.service.decorator;

import org.springframework.stereotype.Component;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoggingNotifier implements Notifier{

  private final Notifier wrapped;

  @Override
  public void notify(UserModel user) {
    System.out.println("[LOG] Iniciando notificação para: " + user.getName());
    wrapped.notify(user);
    System.out.println("[LOG] Notificação concluída para: " + user.getName());
  }

}
