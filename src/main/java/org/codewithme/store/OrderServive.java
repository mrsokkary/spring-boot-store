package org.codewithme.store;

public class OrderServive {
    private PaymentServive paymentServive;

    public OrderServive(PaymentServive paymentServive) {
        this.paymentServive = paymentServive;
    }

    public void placeOrder()
    {
        paymentServive.parocessPayment(500);
    }
}
