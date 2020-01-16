package com.example.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Contact_Details")
@Data
public class ContactDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(length=20,name="Contact_Id")
	private Integer contactId;
	
	@Column(length=20,name="Contact_Name")
	private String contactName;
	
	@Column(length=30,name="Contact_Email")
	private String contactEmail;
	
	@Column(length=20,name="Contact_Number")
	private long phoneNo;

	@Column(length=5,name="SWT")
	private String switches;
	
}
