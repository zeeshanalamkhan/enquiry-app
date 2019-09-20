package com.zeeshan.dto;

import com.zeeshan.domain.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryCommand {

	private Enquiry enquiry;
	private Long[] courses;

}
