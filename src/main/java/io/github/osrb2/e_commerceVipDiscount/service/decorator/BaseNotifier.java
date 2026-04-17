package io.github.osrb2.e_commerceVipDiscount.service.decorator;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;

public class BaseNotifier implements Notifier {

  @Override
  public void notify(UserModel user) {
    System.out.println("Notificação base para: " + user.getName());
  }
}
