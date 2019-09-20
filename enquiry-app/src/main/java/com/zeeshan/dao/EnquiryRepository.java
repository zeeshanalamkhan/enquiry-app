package com.zeeshan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeeshan.domain.Enquiry;
import com.zeeshan.dto.EnquiryDto;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

	@Query("SELECT group_concat(e.enquiryId) FROM Enquiry as e")
	public String findAllIds();

	@Query("SELECT e.enquiryId AS enquiryId, e.doe AS doe, e.committedFees AS fees, c.name AS name, c.phone AS phone,"
			+ " (SELECT count(followupId) FROM Followup f WHERE e=f.enquiry) AS followUpCount,"
			+ " (SELECT group_concat(co.name) FROM Course co, EnquiryCourse ec WHERE e=ec.enquiry AND ec.course=co) AS courses "
			+ " FROM Enquiry e, Contact c WHERE e.contact=c and e.institute.instituteId=?1")
	public List<EnquiryDto> getEnquiryDTOList(Long instituteId);

}
