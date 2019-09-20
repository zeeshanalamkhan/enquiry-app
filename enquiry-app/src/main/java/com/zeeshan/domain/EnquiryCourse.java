package com.zeeshan.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enquirycourse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "enquiryCourseId")
	private Long enquiryCourseId;

	@ManyToOne
	@JoinColumn(name = "courseId", referencedColumnName = "courseId")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	private Enquiry enquiry;

}
