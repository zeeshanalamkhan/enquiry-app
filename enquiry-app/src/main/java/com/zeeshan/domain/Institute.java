package com.zeeshan.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Table(name = "institute")
@Data
public class Institute implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "instituteId")
	private Long instituteId;
	@Column(name = "name")
	private String name;
	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Course> courseList;

	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	@ManyToOne
	private Contact contact;

	public Institute() {
	}

	public Institute(Long instituteId, String name) {
		this.instituteId = instituteId;
		this.name = name;
	}

	public Institute(String name, Date doe, Contact contact) {
		this.name = name;
		this.doe = doe;
		this.contact = contact;
	}

	public Institute(Long instituteId) {
		this.instituteId = instituteId;
	}

}
