package barBossHouse;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InternetOrdersManager implements OrdersManager {

    private Listik<Order> listochek;

    public InternetOrdersManager() {
        this.listochek = new Listik<Order>();
    }

    public InternetOrdersManager(Order[] orders) {

        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < orders.length; i++) {
            if (now.getHour() > 22 | now.getHour() > 0 && now.getHour() < 8 | now.getYear() - orders[i].getDateOfOrder().getYear() < 18)
                throw new UnlawfulActionException("Time of sale of alcohol left");

            listochek.add(orders[i]);

        }
    }

    public boolean add(Order order) throws AlreadyAddedException {

        LocalDateTime now = LocalDateTime.now();

        if (now.getHour() > 22 | now.getHour() > 0 && now.getHour() < 8)
            throw new UnlawfulActionException("Time of sale of alcohol left");

        for (int i = 0; i < listochek.size; i++) {
            if (((Order) listochek.get(i)).getCustomer().equals(order.getCustomer()) & ((Order) listochek.get(i)).getDateOfOrder().equals(order.getDateOfOrder()))
                throw new AlreadyAddedException("The order has already been added");
        }
        listochek.add(order);
        return true;
    }

    public Order getFirstOrder() {
        return (Order) listochek.get(0);
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
        Order[] arr = new Order[listochek.size];
        for (int i = 0; i < listochek.size; i++) {
            arr[i] = listochek.get(i);
        }
        return (Order[]) arr;
    }

    public int getOrderCost() {
        Order[] orders = this.getArrayQueue();
        int cost = 0;
        for (int i = 0; i < listochek.size; i++) {
            cost += (listochek.get(i)).costTotal();
        }
        return cost;
    }


    @Override
    public int ordersQuantity() {
        return listochek.size;
    }

    @Override
    public Order[] getOrders() {
        Order[] arr = new Order[listochek.size];
        for (int i = 0; i < listochek.size; i++) {
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
            count += listochek.get(i).itemQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if (listochek.get(i).equals(item)) {
                count++;
            }
        }
        return count;
    }
    //dr

    @Override
    public int getNumberOrder(LocalDate numberOrderOfDay) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if(listochek.get(i).getDateOfOrder().equals(numberOrderOfDay))
                count++;
        }
        return count;
    }

    @Override
    public Listik getListOrder(LocalDate listOrderOfDay) {
        Listik<Order> listik = new Listik<>();
        for (int i = 0; i <listochek.size ; i++) {
            if(listochek.get(i).getDateOfOrder().equals(listOrderOfDay))
            {
                listik.add(listochek.get(i));
            }
        }
        return listik;
    }

    @Override
    public Listik getListOrderOfCustomer(Customer customer) {
        Listik<Order> listik = new Listik<>();

        for (int i = 0; i <listochek.size ; i++) {
            if(listochek.get(i).getCustomer().equals(customer))
            {
                listik.add(listochek.get(i));
            }
        }
        return listik;
    }
}
