package io.github.osrb2.e_commerceVipDiscount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ECommerceVipDiscountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceVipDiscountApplication.class, args);
	}

}
