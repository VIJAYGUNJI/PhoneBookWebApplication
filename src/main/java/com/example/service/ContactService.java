package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contact;
import com.example.persistance.ContactDetailsEntity;
import com.example.persistance.ContactDetailsRepository;
import com.example.utils.EmailUtils;

@Service
public class ContactService {

	@Autowired
	private ContactDetailsRepository contactdetailsrepo;

	@Autowired
	private EmailUtils emailutils;

	/**
	 * This method is used to save the contact details
	 * 
	 * @param c
	 * @return
	 */
	public boolean saveContact(Contact c) {
		ContactDetailsEntity ce = new ContactDetailsEntity();
		BeanUtils.copyProperties(c, ce);
		ce.setSwitches("Y");
		ContactDetailsEntity save = contactdetailsrepo.save(ce);
		String sub = "Test sub";
		/* String body="String test"; */
		if (save != null) {
			try {
				emailutils.sendMail(c.getContactEmail(), sub, RegistrationMail(c));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return save.getContactId() > 0;

	}

	public List<Contact> getAllContacts() {
		List<ContactDetailsEntity> findAll = contactdetailsrepo.findAll();
		List<Contact> listcontact = new ArrayList<>();
		findAll.forEach(contact -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(contact, c);
			listcontact.add(c);
		});
		return listcontact;
	}

	public Contact getContcatById(Integer cid) {
		Contact contact = new Contact();
		Optional<ContactDetailsEntity> optional = contactdetailsrepo.findById(cid);
		if (optional.isPresent()) {
			ContactDetailsEntity contactDetailsEntity = optional.get();
			BeanUtils.copyProperties(contactDetailsEntity, contact);
		}
		return contact;
	}

	public void deleteContactbyId(Integer id) {
		if (id != null && id != 0) {
			contactdetailsrepo.updateContactDetailsById("N", id);

		}
	}

	public String RegistrationMail(Contact c) throws Exception {
		StringBuilder builder = new StringBuilder();
		FileReader reader = new FileReader(new File("RegistrationFile.txt"));
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			if(line.contains("${contactName}")) {
				  line=line.replace("${contactName}",c.getContactName());
				  }
			if(line.contains("${phoneNo}")) {
				  line=line.replace("${phoneNo}",String.valueOf(c.getPhoneNo()));
				  } 
			if(line.contains("${Friend_Name}")) {
				  line=line.replace("${Friend_Name}","AShok");		
		}
			builder.append(line);
			line=br.readLine();
	}
		br.close();
		return builder.toString();
	}
}
