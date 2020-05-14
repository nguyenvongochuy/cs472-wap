package miu.edu.cs.cs472.repository;

import java.util.Arrays;
import java.util.List;

import miu.edu.cs.cs472.model.ContactMessage;

public class ContactMessageRepository {
	//for dummy database from memory of ArrayList
	private List<ContactMessage> contactMessages = Arrays.asList(
			new ContactMessage("John H. Smith", "Male", "Feedback", "This is a feedback"),
			new ContactMessage("Anna Jones", "Female", "Inquiry", "This is an inquiry"),
			new ContactMessage("Bob W. Adamson", "Male", "Complaint", "This is a complaint"),
			new ContactMessage("Zacary Najib Ali", "Male", "Inquiry", "This is an inquiry"),
			new ContactMessage("Carlos Hernadez", "Male", "Complaint", "This is complaint"),
			new ContactMessage("Tam Le", "Male", "Feedback", "This is a feedback"),
			new ContactMessage("Joe", "Male", "Feedback", "This is a feedback"),
			new ContactMessage("Jonathan", "Female", "Complaint", "This is an inquiry"),
			new ContactMessage("Christopher", "Male", "Complaint", "This is a complaint"),
			new ContactMessage("Ames", "Male", "Inquiry", "This is an inquiry"),
			new ContactMessage("Helmut", "Male", "Complaint", "This is complaint"),
			new ContactMessage("Vo Nguyen", "Male", "Complaint", "This is a feedback")
			);

	/**
	 * Function Return the list of ContactMessage sample
	 * @return the list of ContactMessage sample
	 */
	public List<ContactMessage> getContactMessages() {
		return contactMessages;
	}
	
	
}
