package com.zeeshan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.zeeshan.dao.EnquirySourceRepository;
import com.zeeshan.domain.EnquirySource;

@Controller
public class EnquirySourceController {

	@Autowired
	private EnquirySourceRepository enquirySourceRepository;

	@GetMapping("/sources")
	public String enquirySourses(Model model) {

		EnquirySource cmd = new EnquirySource();
		model.addAttribute("cmd", cmd);
		return "/sources";

	}

	@GetMapping("/enquiry-source-edit/{id}")
	public String edit(@PathVariable Long id, Model model) {

		EnquirySource cmd = enquirySourceRepository.findById(id).get();
		model.addAttribute("cmd", cmd);
		return "/sources";

	}

	@GetMapping("/save-enquiry-source")
	public String save(@ModelAttribute EnquirySource ec) {

		enquirySourceRepository.save(ec);
		return "/redirect:/sources";
	}

	@GetMapping("/enquiry-source-delete/{id}")
	public String delete(@PathVariable Long id) {

		enquirySourceRepository.deleteById(id);
		return "redirect:/sources";

	}

	@ModelAttribute("enquirySourceList")
	public List<EnquirySource> getEnquirySourceList() {
		return enquirySourceRepository.findAll();
		
	}
}
