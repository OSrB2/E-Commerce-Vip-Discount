package io.github.osrb2.e_commerceVipDiscount.service.event;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCreatedEvent {

  private final UserModel user;

  public UserModel getUser() {
    return user;
  }
}
