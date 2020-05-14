package miu.edu.cs.cs472.model;

public class ContactMessage {
	private String customerName;
	private String gender;
	private String category;
	private String message;
	
	public ContactMessage(String customerName, String gender, String category, String message) {
		this.customerName = customerName;
		this.gender = gender;
		this.category = category;
		this.message = message;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
