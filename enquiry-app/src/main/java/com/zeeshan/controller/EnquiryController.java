package com.zeeshan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeeshan.dao.CourseRepository;
import com.zeeshan.dao.EnquiryRepository;
import com.zeeshan.dao.EnquirySourceRepository;
import com.zeeshan.dao.InstituteRepository;
import com.zeeshan.domain.Course;
import com.zeeshan.domain.EnquirySource;
import com.zeeshan.domain.Institute;
import com.zeeshan.dto.EnquiryCommand;
import com.zeeshan.service.CommonService;

@Controller
public class EnquiryController {

	@Autowired
	private InstituteRepository instituteRepository;

	@Autowired
	private EnquirySourceRepository enquirySourceRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CommonService commonService;

	@Autowired
	private EnquiryRepository enquiryRepository;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("cmd", new EnquiryCommand());
		return "/index";
	}

	@GetMapping("/save-enquiry")
	@ResponseBody
	public String save(@ModelAttribute EnquiryCommand cmd) {

		commonService.saveEnquiry(cmd);
		return "Enquiry saved successfully....!";

	}

	@GetMapping("/get-courses")
	@ResponseBody
	public List<Course> getCoursesByInstituteId(@RequestParam Long instId) {

		return courseRepository.findCourseListByInstitute_instituteId(instId);

	}

	@ModelAttribute("instituteList")
	public List<Institute> getInstList() {

		return instituteRepository.getInstCostomList();

	}

	@ModelAttribute("sourceList")
	public List<EnquirySource> getSourceList() {

		return enquirySourceRepository.findAll();

	}

	@GetMapping("/enq-list")
	public String enquiryList(@RequestParam(required = false) Long instId, Model model) {

		model.addAttribute("enquiryList", enquiryRepository.getEnquiryDTOList(instId));
		return "enq-list";

	}

	@GetMapping("/test-get-inst-ids")
	@ResponseBody
	public String getInstIds() {
		return enquiryRepository.findAllIds();

	}

	@PostMapping("/save-followup")
	public String saveFollowup(@RequestParam Long enquiryId, @RequestParam String followup) {

		commonService.saveFollowup(enquiryId, followup);
		return "redirect:/enq-list";

	}

}
