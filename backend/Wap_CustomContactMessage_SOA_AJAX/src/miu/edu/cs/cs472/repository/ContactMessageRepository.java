package miu.edu.cs.cs472.repository;

import java.util.List;

import miu.edu.cs.cs472.model.ContactMessage;
import miu.edu.cs.cs472.util.JSONUtils;

public class ContactMessageRepository {
	//for json database and load to memory of ArrayList
	private List<ContactMessage> contactMessages;
	
	public ContactMessageRepository() {
		//this.contactMessages = JSONUtils.getDataFromJSONFile();
	}

	/**
	 * Function Return the list of ContactMessage sample
	 * @return the list of ContactMessage sample
	 */
	public List<ContactMessage> getContactMessages() {
		this.contactMessages = JSONUtils.getDataFromJSONFile();
		return contactMessages;
	}

	public void addNewContactMessage(ContactMessage contactMessage) {
		//Add contact message to JSON file
		this.contactMessages = JSONUtils.getDataFromJSONFile();
		System.out.println("addNewContactMessage: " + contactMessages);
		long newId = getLatestId() + 1;
		//System.out.println("One item: " + contactMessage);
		contactMessage.setId(newId);
		contactMessage.setDelete("false");
		JSONUtils.createNewJSONRecord(this.contactMessages, contactMessage);

	}
	
	public long getLatestId() {
		return contactMessages.get(contactMessages.size()-1).getId();
	}
	
	
}
