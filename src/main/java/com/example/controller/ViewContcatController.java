package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Contact;
import com.example.service.ContactService;

@Controller
public class ViewContcatController {
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping(value="/editContact" ,method=RequestMethod.GET)
	public String editConatctById(Model model,HttpServletRequest request)
	{
		Contact contacts;
		String cid = request.getParameter("contactId");
		if(cid!=null)
		{
			int contactid=Integer.parseInt(cid);
			contacts = contactservice.getContcatById(contactid);
			model.addAttribute("contact", contacts);
		}
		return "contactInfo";	
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public String deleteContactById(Model model,HttpServletRequest request) {
		String cid = request.getParameter("contactId");
		if(cid!=null)
		{
			int contactid=Integer.parseInt(cid);
	contactservice.deleteContactbyId(contactid);
	
	}
		return "viewContact";
}
}