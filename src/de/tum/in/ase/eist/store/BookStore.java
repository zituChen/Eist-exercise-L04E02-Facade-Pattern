package de.tum.in.ase.eist.store;

import de.tum.in.ase.eist.ecommerce.*;

// TODO 4 remove all associations to the different controllers in all classes of the package store and use the facade
// instead.
public class BookStore {

	private static int count = 1;
	private final String address;
	private final String name;
	private final int id;
	//private final OrderController orderController;
	//private final ShippingController shippingController;

	private final ECommerceFacade eCommerceFacade;

	public BookStore(String address, String name) {
		this.address = address;
		this.name = name;
		this.id = generateBookStoreId();
		//this.orderController = new OrderController();
		//this.shippingController = new ShippingController();
		this.eCommerceFacade = new ECommerceFacade();
	}

	public void acceptOrder(String shippingAddress, String phoneNumber) {
		System.out.println("Accepting shipping order.");
		Order order = eCommerceFacade.retrieveLatestOrder(id);
		eCommerceFacade.processOrder(order, phoneNumber);
		eCommerceFacade.shipOrder(order, shippingAddress);
		//order.setShipping(shippingController.createShipping(shippingAddress));
		//shippingController.shipOrder(order);
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Book store " + name + ", located at " + address;
	}

	private int generateBookStoreId() {
		count += 2;
		return count;
	}

}
