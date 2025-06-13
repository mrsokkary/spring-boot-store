package org.codewithme.store;

public class StripePaymentServive implements PaymentServive {
    @Override
    public void parocessPayment(double amount)
    {
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);
    }
}
