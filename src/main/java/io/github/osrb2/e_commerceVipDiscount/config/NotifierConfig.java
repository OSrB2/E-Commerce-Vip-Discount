package io.github.osrb2.e_commerceVipDiscount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.osrb2.e_commerceVipDiscount.service.decorator.BaseNotifier;
import io.github.osrb2.e_commerceVipDiscount.service.decorator.LoggingNotifier;
import io.github.osrb2.e_commerceVipDiscount.service.decorator.Notifier;

@Configuration
public class NotifierConfig {

  @Bean
  public Notifier notifier() {
    Notifier base = new BaseNotifier();
    return new LoggingNotifier(base); 
  }
}
