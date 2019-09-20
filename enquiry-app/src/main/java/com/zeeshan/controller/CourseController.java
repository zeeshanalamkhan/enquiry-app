package com.zeeshan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeeshan.dao.CourseRepository;
import com.zeeshan.dao.InstituteRepository;
import com.zeeshan.domain.Course;
import com.zeeshan.domain.Institute;

@Controller
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private InstituteRepository instituteRepository;

	@GetMapping("/courses")
	public String form(Model model) {
		model.addAttribute("cmd", new Course());
		return "/courses";

	}

	@GetMapping("/save-course")
	public String save(@ModelAttribute Course c) {

		courseRepository.save(c);
		return "redirect:/courses";
	}

	@ModelAttribute("instituteList")
	public List<Institute> getInstituteList() {
		return instituteRepository.getInstCostomList();
	}

	@ModelAttribute("courseList")
	public List<Map<String, Object>> getCourseList() {
		return courseRepository.getCourses();
	}

	@GetMapping("tmp-courses")
	@ResponseBody
	public List<Map<String, Object>> courseListTemp() {
		return courseRepository.getCourses();
	}

}
