package de.tum.in.ase.eist.ecommerce;

public class ECommerceFacade {

    private AdvertisementController advertisementController;
    private OrderController orderController;
    private ShippingController shippingController;

    public ECommerceFacade() {
        this.advertisementController = new AdvertisementController();
        this.orderController = new OrderController();
        this.shippingController = new ShippingController();
    }
    public void processOrder(Order order) {
        this.orderController.processOrder(order);
    }

    public void processOrder(Order order, String string) {
        this.orderController.processOrder(order, string);

    }

    public Order retrieveLatestOrder(int i) {
        return this.orderController.retrieveLatestOrder(i);
    }

    public void playAdvertisement(int i) {
        this.advertisementController.playAdvertisement(i);
    }

    public void shipOrder(Order order, String address) {
        order.setShipping(shippingController.createShipping(address));
        this.shippingController.shipOrder(order);

    }


}
