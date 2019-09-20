package com.zeeshan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
@Table(name = "enquirySource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquirySource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "enquirySourceId")
	private Long enquirySourceId;

	@Column(name = "name")
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;

	public EnquirySource(String name) {
		this.name = name;
	}

}
