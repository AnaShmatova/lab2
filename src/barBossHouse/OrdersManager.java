package barBossHouse;

public interface OrdersManager {

    int ordersQuantity();
    Order[] getOrders();
    int ordersCostSummary();
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
}
