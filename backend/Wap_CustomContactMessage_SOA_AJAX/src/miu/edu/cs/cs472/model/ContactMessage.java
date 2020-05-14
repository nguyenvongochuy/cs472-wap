package miu.edu.cs.cs472.model;

public class ContactMessage {
	private long id;
	private String customerName;
	private String gender;
	private String category;
	private String message;
	private String delete;
	
	public ContactMessage(long id, String customerName, String gender, String category, String message) {
		this.id = id;
		this.customerName = customerName;
		this.gender = gender;
		this.category = category;
		this.message = message;
		this.delete = "false";
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "ContactMessage [id=" + id + ", customerName=" + customerName + ", gender=" + gender + ", category="
				+ category + ", message=" + message + "]";
	}
	
	
	
}
