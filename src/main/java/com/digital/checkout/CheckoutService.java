package com.digital.checkout;

import java.util.Optional;

public interface CheckoutService {
	

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}


