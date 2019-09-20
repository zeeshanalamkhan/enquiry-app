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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enquiry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "enquiryId")
	private Long enquiryId;

	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date doe;

	@Column(name = "nextCallDate")
	@Temporal(TemporalType.DATE)
	private Date nextCallDate;

	@Column(name = "remark")
	private String remark;

	@Column(name = "committedFees")
	private Double committedFees;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdate")
	private Date lastUpdate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Followup> followupList;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<EnquiryCourse> enquiryCourseList;

	@ManyToOne
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	private Contact contact;

	@ManyToOne
	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	private Institute institute;

	@ManyToOne
	@JoinColumn(name = "enquirySourceId", referencedColumnName = "enquirySourceId")
	private EnquirySource enquirySource;

}
