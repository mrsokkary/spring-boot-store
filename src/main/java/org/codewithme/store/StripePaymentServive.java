package org.codewithme.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("stripe")
//@Primary
public class StripePaymentServive implements PaymentServive {

    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;


    @Override
    public void parocessPayment(double amount)
    {
        System.out.println("STRIPE");
        System.out.println("API URL: " + apiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("Supported currencies: " + supportedCurrencies);
        System.out.println("Timeout: " + timeout);
        System.out.println("Amount to pay: " + amount);
    }
}
