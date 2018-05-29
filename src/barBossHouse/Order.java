package barBossHouse;

import java.time.LocalDateTime;

public interface Order {


    boolean add(MenuItem item);

    boolean remove(String itemName);

    boolean remove(MenuItem item);

    int removeAll(String itemName);

    int removeAll(MenuItem item);

    int itemsQuantity();

    MenuItem[] getItems();

    int costTotal();

    int itemQuantity(String itemName);

    int itemQuantity(MenuItem itemName);

    String[] itemsNames();

    MenuItem[] sortedItemsByCostDesc();

    Customer getCustomer();

    void setCustomer(Customer customer);

    LocalDateTime setDateOfOrder(LocalDateTime timeOfOrder);

    LocalDateTime getDateOfOrder();
}
