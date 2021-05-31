package clients;

import domain.CoffeeAttendant;
import domain.Customer;

public class CoffeeShop {
	public static void main(String[] args) {
		Customer cust1 = new Customer("Mike","Cappucino");
		Customer cust2 = new Customer("Supriya","Latte");
		Customer cust3 = new Customer("Smartha","Mocha");
		
		CoffeeAttendant server = new CoffeeAttendant();
		
		server.takeOrder(cust1);
		server.takeOrder(cust2);
		server.takeOrder(cust3);
		
		server.prepareDrink("Cappucino");
		server.prepareDrink("Mocha");
		server.prepareDrink("Latte");
	}
}
