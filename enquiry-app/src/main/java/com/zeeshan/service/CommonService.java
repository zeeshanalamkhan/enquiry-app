package com.zeeshan.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeeshan.dao.AddressRepository;
import com.zeeshan.dao.ContactRepository;
import com.zeeshan.dao.CourseRepository;
import com.zeeshan.dao.EnquiryCourseRepository;
import com.zeeshan.dao.EnquiryRepository;
import com.zeeshan.dao.EnquirySourceRepository;
import com.zeeshan.dao.FollowupRepository;
import com.zeeshan.dao.InstituteRepository;
import com.zeeshan.domain.Address;
import com.zeeshan.domain.Contact;
import com.zeeshan.domain.Enquiry;
import com.zeeshan.domain.EnquiryCourse;
import com.zeeshan.domain.Followup;
import com.zeeshan.domain.Institute;
import com.zeeshan.dto.EnquiryCommand;

@Service
public class CommonService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EnquiryCourseRepository enquiryCourseRepository;

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private EnquirySourceRepository enquirySourceRepository;

	@Autowired
	private FollowupRepository followupRepository;

	@Autowired
	private InstituteRepository instituteRepository;

	@Transactional
	public void saveInstitute(Institute institute) {

		addressRepository.save(institute.getContact().getPermanentAddress());
		contactRepository.save(institute.getContact());
		instituteRepository.save(institute);

	}

	@Transactional
	public void saveEnquiry(EnquiryCommand cmd) {

		Address address = cmd.getEnquiry().getContact().getPermanentAddress();
		addressRepository.save(address);

		Contact contact = cmd.getEnquiry().getContact();
		contactRepository.save(contact);

		Enquiry enquiry = cmd.getEnquiry();
		enquiry.setInstitute(instituteRepository.getOne(enquiry.getInstitute().getInstituteId()));
		enquiry.setEnquirySource(enquirySourceRepository.getOne(enquiry.getEnquirySource().getEnquirySourceId()));
		Date date = new Date();
		enquiry.setDoe(date);
		enquiry.setLastUpdate(date);
		enquiryRepository.save(enquiry);

		Long[] courseIds = cmd.getCourses();
		for (Long courseId : courseIds) {
			EnquiryCourse enquiryCourse = new EnquiryCourse();
			enquiryCourse.setEnquiry(enquiry);
			enquiryCourse.setCourse(courseRepository.getOne(courseId));
			enquiryCourseRepository.save(enquiryCourse);

		}
	}

	@Transactional
	public void saveFollowup(Long enquiryId, String detail) {

		Followup followUp = new Followup();
		followUp.setDetail(detail);
		followUp.setEnquiry(enquiryRepository.getOne(enquiryId));
		followUp.setDoe(new Date());
		followupRepository.save(followUp);
		
	}

}
