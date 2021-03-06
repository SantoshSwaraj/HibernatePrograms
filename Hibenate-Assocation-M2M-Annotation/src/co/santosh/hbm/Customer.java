package co.santosh.hbm;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	 public Customer() {
	 }
	 
	 public Customer(int customerId, String customerName){
		 this.customerId = customerId;
		 this.customerName = customerName;
	 }
	 
	
	@Id
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}

