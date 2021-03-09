package com.digital.checkout;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class CheckoutItemEntity {
	 @Id
	    @GeneratedValue
	    private Long id;

	    @Column
	    private String product;

	    @ManyToOne
	    private CheckoutEntity checkout;
}
