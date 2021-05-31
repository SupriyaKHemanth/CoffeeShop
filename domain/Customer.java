package domain;

public class Customer implements WaitingCustomer{
	private String name;
	private String preparedDrink;
	
	public Customer(String name, String drink) {
		this.name = name;
		this.preparedDrink = drink;
	}

	public String getPreparedDrink() {
		return this.preparedDrink;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public void orderReady(String preparedDrink) {
		System.out.println(name + ": Thank you, I've recieved my "
				+ preparedDrink + " and leaving the store now...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
