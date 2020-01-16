package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Contact;
import com.example.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactservice;


	@RequestMapping("/")
	public String getFormDetails(Model model) {
		Contact c = new Contact(); // used to bind the form data
		model.addAttribute("contact", c);// to bind form data to our model class
		return "contactInfo";

	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, Model model) {
		boolean saveContact = contactservice.saveContact(c);
		if (saveContact) {
			model.addAttribute("SuccessMessage", "contact saved successfully");
		} else {
			model.addAttribute("FailureMessage", "conatact not saved successfully");
		}
		return "contactInfo";
	}
	
	

	@RequestMapping(value = "/getAllData",method=RequestMethod.GET)
	public String viewAllContacts(Model model) {
		List<Contact> allContacts = contactservice.getAllContacts();
		model.addAttribute("contactList", allContacts);
		return "viewContact";
	}

}
