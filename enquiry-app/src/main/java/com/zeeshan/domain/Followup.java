package com.zeeshan.domain;

import java.io.Serializable;
import java.util.Date;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "followup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Followup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "followupId")
	private Long followupId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "doe")
	private Date doe;

	@Column(name = "detail")
	private String detail;

	@ManyToOne
	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	private Enquiry enquiry;

}
