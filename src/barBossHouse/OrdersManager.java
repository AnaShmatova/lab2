package barBossHouse;

public interface OrdersManager {

    int ordersQuantity();
    Order[] getOrders();
    double ordersCostSummary();
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
}
