package com.digital.checkout;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {
	 private final CheckoutProcessor checkoutProcessor;

	    private final PaymentService paymentService;

	    @StreamListener(CheckoutProcessor.INPUT)
	    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
	        log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);
	        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
	        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
	                .setCheckoutCode(paymentEntity.getCheckoutCode())
	                .setPaymentCode(paymentEntity.getCode())
	                .build();
	        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
	    }
}
