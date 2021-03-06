package com.booking.gateway;

import com.booking.util.PayBuddyRestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayBuddyGateway {

    private final PayBuddyRestTemplate restTemplate = new PayBuddyRestTemplate();
    private final String payBuddyBaseUrl;

    public PayBuddyGateway(String payBuddyBaseUrl) {
        this.payBuddyBaseUrl = payBuddyBaseUrl;
    }

    public PayBuddyPaymentResponse makePayment(String creditCardNumber,
                                               LocalDate creditCardExpiry,
                                               BigDecimal amount) {
        final PayBuddyPaymentRequest request =
                new PayBuddyPaymentRequest(creditCardNumber, creditCardExpiry, amount);

        return restTemplate.postForObject(payBuddyBaseUrl + "/payments",
                request,
                PayBuddyPaymentResponse.class);
    }
}
