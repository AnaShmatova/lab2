package barBossHouse;

import java.time.LocalDate;

public interface OrdersManager {

    int ordersQuantity();
    Order[] getOrders();
    double ordersCostSummary();
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);

    int getNumberOrder(LocalDate numberOrderOfDay);
    Listik getListOrder (LocalDate listOrderOfDay);
    Listik getListOrderOfCustomer(Customer customer);
}
