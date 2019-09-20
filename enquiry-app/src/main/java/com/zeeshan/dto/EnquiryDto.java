package com.zeeshan.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public interface EnquiryDto {

	public Long getEnquiryId();

	public String getPhone();

	public String getName();

	public String getCourses();

	public Integer getFollowUpCount();

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	public Date getDoe();

	public Float getFees();

}
