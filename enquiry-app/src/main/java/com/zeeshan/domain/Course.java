package com.zeeshan.domain;

import java.io.Serializable;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "courseId")
	private Long courseId;
	@Column(name = "name")
	private String name;
	@Column(name = "fees")
	private Double fees;

	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	@ManyToOne
	private Institute institute;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<EnquiryCourse> enquiryCourseList;

	@ManyToOne
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	private Contact contact;

	@ManyToOne
	@JoinColumn(name = "enquirySourceId", referencedColumnName = "enquirySourceId")
	private EnquirySource enquirySource;

}
