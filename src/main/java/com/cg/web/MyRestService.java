package com.cg.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class MyRestService {

	@GetMapping("/viewall")
	public String viewCart() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return "View cart " + uname;
	}

	@SecurityRequirement(name = "BearerAuth")
	@GetMapping("/addcart")
	public String addCart() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Add cart " + uname;
	}

	@SecurityRequirement(name = "BearerAuth")
	@GetMapping("/editcart")
	public String editCart() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Edit cart " + uname;
	}

	@SecurityRequirement(name = "BearerAuth")
	@GetMapping("/addproduct")
	public String addProduct() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Add Product " + uname;
	}

	@SecurityRequirement(name = "BearerAuth")
	@GetMapping("/search")
	public String searchCart() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Search Cart " + uname;
	}
}
