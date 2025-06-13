package org.codewithme.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${payment-gateway:stripe}")
    private String paymentGateway;

    @Bean
    public PaymentServive stripe() {
        if (paymentGateway.toLowerCase().equals("stripe"))
            return new StripePaymentServive();
        return new PayPalPaymentService();
    }

    public PaymentServive paypal() {
        return new PayPalPaymentService();
    }

    @Bean
    public OrderServive orderServive() {
        return new OrderServive(stripe());
    }
}
