package com.zeeshan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressId")
	private Long addressId;

	@Column(name = "detail")
	private String detail;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private Integer zip;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Contact> contactList;

}
