package org.codewithme.store;

import org.springframework.stereotype.Service;

@Service("paypal")
public class PayPalPaymentService implements PaymentServive{

    @Override
    public void parocessPayment(double amount) {
        System.out.println("PayPal");
        System.out.println("Amount: " + amount);
    }
}
