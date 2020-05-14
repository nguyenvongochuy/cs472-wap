package miu.edu.cs.cs472.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import miu.edu.cs.cs472.model.ContactMessage;
import miu.edu.cs.cs472.repository.ContactMessageRepository;

public class ContactMessageService {
	private ContactMessageRepository contactMessageRepository;

	public ContactMessageService() {
		this.contactMessageRepository = new ContactMessageRepository();
	}
	
	/**
	 * Function return the Contact Messages (not sort)
	 * @return the list of Contact Message (not sort)
	 */
	private  List<ContactMessage> getContactMessages() {
		return contactMessageRepository.getContactMessages();
	}
	
	public String getContactMessagesJSON() {
		return convertContactMessageListToJSON(getContactMessages());
	}
	
	/**
	 * Function return the Contact Messages (sorted)
	 * @return the list of Contact Message (sorted)
	 */
	private List<ContactMessage> getContactMessagesSorted() {
		return contactMessageRepository.getContactMessages().stream()
				.sorted(Comparator.comparing(ContactMessage::getCustomerName)).collect(Collectors.toList());
	}
	
	public String getContactMessagesSortedJSON() {
		return convertContactMessageListToJSON(getContactMessagesSorted());
	}
	
	/**
	 * Function return list of ContactMessages which make filter by searching
	 * @param searchValue the value need to be search
	 * @return list of searched ContactMessages
	 */
	private List<ContactMessage> getContactMessagesSearchByKeyword(String searchValue) {
		String searchValueLowerCase = searchValue.toLowerCase();
		return contactMessageRepository.getContactMessages().stream()
				.filter(v -> v.getCustomerName().toLowerCase().contains(searchValueLowerCase) || v.getGender().toLowerCase().contains(searchValueLowerCase) 
						|| v.getCategory().toLowerCase().contains(searchValueLowerCase) || v.getMessage().toLowerCase().contains(searchValueLowerCase))
				.sorted(Comparator.comparing(ContactMessage::getCustomerName)).collect(Collectors.toList());
	}
	
	public String getContactMessagesSearchByKeywordJSON(String searchValue) {
		return convertContactMessageListToJSON(getContactMessagesSearchByKeyword(searchValue));
	}
	
	/**
	 * Filter List of ContactMessage again for paging
	 * @param list list of ContactMessages
	 * @param firstIndex index of row from beginning
	 * @param recordsPerPage the records need to display each page
	 * @return sublist of ContactMessage for each paging
	 */
	private List<ContactMessage> getContactMessagesSortedByIndex(List<ContactMessage> list, int firstIndex, int recordsPerPage) {
		List<ContactMessage> newList = new ArrayList<>();
		int recordUp = firstIndex+recordsPerPage<=list.size()?firstIndex+recordsPerPage:list.size();
		for (int i=firstIndex; i< recordUp; i++ ) {
			newList.add(list.get(i));
		}
		return newList;
	}
	
	public String getContactMessagesSortedByIndexJSON(List<ContactMessage> list, int firstIndex, int recordsPerPage) {
		return convertContactMessageListToJSON(getContactMessagesSortedByIndex(list, firstIndex, recordsPerPage));
		
	}

	/**
	 * Get number of records base on List of ContactMessage
	 * @param list of ContactMessages
	 * @return the size of ContactMessages list
	 */
	public int getNoOfRecords(List<ContactMessage> list) {
		return list.size();
	}
	
	private String convertContactMessageListToJSON(List<ContactMessage> contactMessages) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
        int count = 0;
		for (ContactMessage contactMessage : contactMessages) {
			sb.append("{");
			sb.append(String.format("\"id\": %s, \"customerName\": \"%s\", \"gender\": \"%s\", \"category\": \"%s\", \"message\": \"%s\" , \"delete\": \"%s\" ",
					contactMessage.getId(), contactMessage.getCustomerName(), contactMessage.getGender(), contactMessage.getCategory(), contactMessage.getMessage(), contactMessage.getDelete()));
			sb.append("}");
            if(++count != contactMessages.size()) {
                sb.append(", ");
            }
			
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void addContactMessage(ContactMessage contactMessage) {
		contactMessageRepository.addNewContactMessage(contactMessage);
	}
	
}
