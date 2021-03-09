package com.digital.checkout;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingEntity {
	 @Id
	    @GeneratedValue
	    private Long id;

	    @Column
	    private String address;

	    @Column
	    private String complement;

	    @Column
	    private String country;

	    @Column
	    private String state;

	    @Column
	    private String cep;

	    @OneToOne(mappedBy = "shipping")
	    private CheckoutEntity checkout;
	}

