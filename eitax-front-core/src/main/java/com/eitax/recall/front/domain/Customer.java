package com.eitax.recall.front.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
}
