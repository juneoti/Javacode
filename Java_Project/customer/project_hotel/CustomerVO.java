package project_hotel;

public class CustomerVO {
	private String customerID;
	private String customerPW;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private String customerBirth;
	private String customerGender;
	
	public CustomerVO() {
	}
	
	public CustomerVO(String customerID, String customerPW, String customerName, String customerPhone,
			String customerEmail, String customerBirth, String customerGender) {
		this.customerID = customerID;
		this.customerPW = customerPW;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String getCustomerPW() {
		return customerPW;
	}
	
	public void setCustomerPW(String customerPW) {
		this.customerPW = customerPW;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerBirth() {
		return customerBirth;
	}
	
	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}
	
	public String getCustomerGender() {
		return customerGender;
	}
	
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	@Override
	public String toString() {
		return "CustomerVO [customerID=" + customerID + ", customerPW=" + customerPW + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail + ", customerBirth="
				+ customerBirth + ", customerGender=" + customerGender + "]";
	}
	
}
