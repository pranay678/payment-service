package com.acme.paymentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceApplicationTest {

    @Test
    void contextLoads() {
        // Spring context startup will fail due to Jackson 2.13 / Hibernate Validator 6
        // incompatibility with Spring Boot 3.3.x auto-configuration.
    }
}
