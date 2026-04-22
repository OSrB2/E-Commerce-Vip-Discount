package io.github.osrb2.e_commerceVipDiscount.service.decorator;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;

public interface Notifier {
  void notify(UserModel user);
}
