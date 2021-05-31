package domain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import domainDao.CustomerDAO;

public class CoffeeAttendant {
	private List<Customer> customerList;
	private List<String> completedDrinks;
	private CustomerDAO custDao = new CustomerDAO();

	public CoffeeAttendant() {
		customerList = custDao.getCustomerList();
		completedDrinks = new CopyOnWriteArrayList<String>();
	}

	public void takeOrder(Customer customer) {
		custDao.registerCustomers(customer);
		System.out.println("Took order for " + customer.getPreparedDrink());
	}

	public void prepareDrink(String drinkToPrepare) {
		double num = Math.random() * 10;
		try {
			Thread.sleep((long) (num) * 1000);
			completedDrinks.add(drinkToPrepare);
			System.out.println("Prepared " + drinkToPrepare);
			callOutCompletedOder();
		} catch (InterruptedException e) {
			System.out.println("Could not prepare drink...!!!");
			e.printStackTrace();
		}
	}

	public void callOutCompletedOder() {
//		Iterator<WaitingCustomer> i = customerList.iterator();

		for (String drink : completedDrinks) {
			for (Customer c : customerList) {
				if (c.getPreparedDrink() == drink) {
					c.orderReady(drink);
					custDao.removeCustomer(c);
					customerList = custDao.getCustomerList();
					completedDrinks.remove(drink);
					if(customerList.isEmpty()) {
						System.out.println("No more customers for the day...!");
					}
				}
			}
		}

//		while(i.hasNext()) {
//			Customer c = (Customer)i.next();
//			if(c.getPreparedDrink() == completedDrink) {
//				c.orderReady(completedDrink);
//				custDao.removeCustomer(c);
//			}
//		}
	}
}
