package org.codewithme.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderServive {

    private PaymentServive paymentServive;

    public OrderServive(@Qualifier("stripe") PaymentServive paymentServive) {
        this.paymentServive = paymentServive;
    }

    public void placeOrder()
    {
        paymentServive.parocessPayment(10);
    }
}
