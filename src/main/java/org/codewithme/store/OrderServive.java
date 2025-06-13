package org.codewithme.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.sql.SQLOutput;

//@Service
public class OrderServive {

    private PaymentServive paymentServive;

    public OrderServive(PaymentServive paymentServive) {
        this.paymentServive = paymentServive;
        System.out.println("Order service created");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("Order service init - PostConstruct");
    }

    public void placeOrder()
    {
        paymentServive.parocessPayment(10);
    }

    @PreDestroy
    public void cleanup()
    {
        System.out.println("Order service cleanup - PreDestroy");
    }
}
