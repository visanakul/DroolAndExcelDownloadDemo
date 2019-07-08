package com.drool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drool.service.IUserService;

@Controller
public class DocumentController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/home")
	public String handleHomePage() {
		System.out.println("/home request");
		return "index";
	}
	@RequestMapping("/download")
	public String handleDocDownload(@RequestParam("type") String type,Model model) {
		System.out.println("Type : "+type);
		if (type.equals("excel") || type.equals("pdf")) {
			model.addAttribute("users", userService.getAllUsers());
			return type;
		} else {
			return "error";
		}
	}
}
