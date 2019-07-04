package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Product;
import com.app.service.ProductService;
import com.app.util.EmailUtil;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Autowired
	private EmailUtil mailUtil;
	
	//1.Show form with Backing Object
	
	@RequestMapping("/reg")
	public String showReg(Model map) {
		//Form Backing Object
		map.addAttribute("product", new Product());
		return "Register";	
	}
	
	//2.Read Form Data On click submit
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Product product, Model map, @RequestParam MultipartFile fileOb) {
		//call service layer
		Integer id=service.saveProduct(product);
		mailUtil.send(product.getEmail(), "Product added", "Hello User", fileOb);
		map.addAttribute("message", "Product '"+id+"' Saved!!");
		//clean form Backing object
		map.addAttribute("product", new Product());
		return "Register";	
	}
	
	//3.Fetch all rows from db to ui
	
	@RequestMapping("/all")
	public String showAll(Model map) {
		//fetch all rows from db
		List<Product> obs = service.getAllProducts();
		//send to ui
		map.addAttribute("list", obs);
		return "Data";
	}
	
	//4. Delete row based on Id
	@RequestMapping("/delete")
	public String remove(@RequestParam Integer id) {
		//delete  row based on Id
		service.deleteProduct(id);
		//response.sendRedirect
		return "redirect:all";
	}
	
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model map) {
	    // load object form db
		Product p= service.getProductById(id);
	    // form baking object
		map.addAttribute("product", p);
		map.addAttribute("Mode", "EDIT");
		return "Register";
	}

}
