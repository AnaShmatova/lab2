package barBossHouse;

import com.sun.org.apache.xpath.internal.operations.Or;

public class InternetOrdersManager implements OrdersManager {

    private Listik<Order> listochek;

    public InternetOrdersManager() {
        this.listochek = new Listik<Order>();
    }

    public InternetOrdersManager(Order[] orders) {
        for (int i = 0; i < orders.length; i++) {
            listochek.add(orders[i]);
        }
    }

    public boolean add(Order order) {
        listochek.add(order);
        return true;
    }

    public Order getFirstOrder() {
        return (Order)listochek.get(0);
    }

    public Order getFirstOrderAndDelete() {
        Order order = getFirstOrder();
        listochek.remove(0);
        return order;
    }

    public int getSizeQueue() {
        return listochek.size;
    }

    public Order[] getArrayQueue() {
        MenuItem[] arr = new MenuItem[listochek.size];
        for (int i = 0; i < listochek.size ; i++) {
            arr[i] = (MenuItem) listochek.get(i);
        }
        return (Order[]) arr;
    }

    public int getOrderCost() {
        Order[] orders = this.getArrayQueue();
        int cost = 0;
        for (int i = 0; i < listochek.size; i++) {
            cost += ((Order)listochek.get(i)).costTotal();
        }
        return cost;
    }

    public int getQualityOrder(String name) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            count += ((Order)listochek.get(i)).itemQuantity(name);
        }
        return count;
    }

    public int getQualityOrder(MenuItem item) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            count += ((Order)listochek.get(i)).itemQuantity(item);
        }
        return count;
    }

    @Override
    public int ordersQuantity() {
        return listochek.size;
    }

    @Override
    public Order[] getOrders() {
        Order[] arr = new Order[listochek.size];
        for (int i = 0; i < listochek.size ; i++) {
            arr[i] = listochek.get(i);
        }
        return arr;
    }

    @Override
    public double ordersCostSummary() {
        double sum = 0;
        for (int i = 0; i < listochek.size; i++) {
            sum += listochek.get(i).costTotal();
        }
        return sum;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            count += ((Order)listochek.get(i)).itemQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if(listochek.get(i).equals(item)) {
                count++;
            }
        }
        return count;
    }
}
