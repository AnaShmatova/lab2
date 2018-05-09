package barBossHouse;

import com.sun.org.apache.xpath.internal.operations.Or;

public class InternetOrdersManager implements OrdersManager {

    private Listik<Order> listochek;

    public InternetOrdersManager() {
        this.listochek = new Listik<Order>();
    }

    public InternetOrdersManager(Order[] orders) {

    }

    public boolean add(Order order) {
        listochek.add((Order) order);
        return true;
    }

    public int withoutDeleting() {
        Order first = listochek.get().getFirst();
    }

}
