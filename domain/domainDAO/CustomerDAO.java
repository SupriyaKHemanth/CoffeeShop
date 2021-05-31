package domainDao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import domain.Customer;

public class CustomerDAO {
	private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();
	
	public void registerCustomers(Customer c) {
		customerList.add(c);
	}
	
	public void removeCustomer(Customer c) {
		customerList.remove(c);
	}
	
	@Override
	public String toString() {
		return "CustomerDAO [customerList=" + customerList.size() + "]";
	}

	public List<Customer> getCustomerList(){
		return this.customerList;
	}
}
