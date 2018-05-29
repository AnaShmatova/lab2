package barBossHouse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Predicate;


public class TableOrdersManager implements OrdersManager {
    private Order[] orders;
    private Order interfes;

    public TableOrdersManager(int newTableNumber) {
        if (newTableNumber < 0)
            throw new NegativeSizeException("Number of elements is negative");

        orders = new TableOrder[newTableNumber];
    }

    public void add(TableOrder order, int tableNumber) throws AlreadyAddedException {

        LocalDateTime now = LocalDateTime.now();

        if (now.getHour() > 22 | now.getHour() > 0 && now.getHour() < 8 | now.getYear() - order.getDateOfOrder().getYear() < 18)
            throw new UnlawfulActionException("Time of sale of alcohol left");

        if (orders[tableNumber] != null)
            throw new AlreadyAddedException("The order has already been added");

        orders[tableNumber - 1] = order;
    }

    public TableOrder getOrder(int tableNumber) {
        return (TableOrder) orders[tableNumber - 1];
    }


    public void removeOrder(int tableNumber) {
        orders[tableNumber - 1] = null;
    }

    public int getFreeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i;
            }
        }
        return -1;
    }


    private int[] tableNumbers(Predicate<Order> isP) {
        int j = 0;
        int[] numberFreeTables = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            if (isP.test(orders[i])) {
                numberFreeTables[j] = i;
                j++;
            }
        }
        return numberFreeTables;
    }

    //todo поправил - эти 2 метода не должны принимать параметры
    //todo и я их так явно не называл, переименовал первый метод - лучше теперь звучит, второй переименуй сама
    public int[] noFreeTableNumbers() {
        return tableNumbers(new NotIsNullPredicate());
    }

    public int[] freeTableNumbers() throws NoFreeTableException {

        int[] arr = tableNumbers(new IsNullPredicate());
        ;
        if (arr.length == 0)
            throw new NoFreeTableException("There are no available tables");

        return arr;


    }

    public TableOrder[] getOrders() throws NoFreeTableException {

        int[] table = freeTableNumbers();
        TableOrder[] atTheMomentOrders = new TableOrder[table.length];
        for (int i = 0; i < table.length; i++) {
            atTheMomentOrders[i] = (TableOrder) orders[table[i]];
        }
        return atTheMomentOrders;
    }

    public double ordersCostSummary() {
        double sum = 0;
        for (int i = 0; i < orders.length; i++) {
            sum += orders[i].costTotal();
        }
        return sum;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        String[] mass;
        for (int i = 0; i < orders.length; i++) {

            mass = orders[i].itemsNames();
            for (int j = 0; j < mass.length; j++) {
                if (mass[i].equals(itemName))
                    count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals(item)) {
                count++;
            }
        }
        return count;
    }


    @Override
    public int getNumberOrder(LocalDate numberOrderOfDay) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getDateOfOrder().equals(numberOrderOfDay))
                count++;
        }
        return count;
        //
    }

    @Override
    public Listik getListOrder(LocalDate listOrderOfDay) {
        Listik<Order> listik = new Listik<>();
        for (int i = 0; i <orders.length ; i++) {
            if(orders[i].getDateOfOrder().equals(listOrderOfDay))
            {
                listik.add(orders[i]);
            }
        }
        return listik;
    }

    @Override
    public Listik getListOrderOfCustomer(Customer customer) {
        Listik<Order> listik = new Listik<>();

        for (int i = 0; i <orders.length ; i++) {
            if(orders[i].getCustomer().equals(customer))
            {
                listik.add(orders[i]);
            }
        }
        return listik;

    }


    public int ordersQuantity() {
        return orders.length;
    }

    public int addItem(MenuItem item, int tableNumber) {
        int sum = 0;
        for (int i = 0; i < tableNumber; i++) {
            if (tableNumber != 0) {
                sum++;
            }
        }
        return sum;
    }

    public int remove(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {

            if (orders[i].equals(order)) {
                orders[i] = null;
                //todo просто ордер делаем null, сдвигать массив в ЭТОМ КЛАССЕ НЕ НАДО!
                //сделала
                count++;
                return i;
            }
        }
        return -1;
    }

    public int removeAll(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {

            if (orders[i].equals(order)) {
                orders[i] = null;
                //todo просто ордер делаем null, сдвигать массив в ЭТОМ КЛАССЕ НЕ НАДО!
                //сделали
                count++;
            }
        }
        if (count > 0)
            return count;
        else
            return -1;
    }


}

class IsNullPredicate implements java.util.function.Predicate<Order> {

    @Override
    public boolean test(Order order) {
        return order == null;
    }
}


class NotIsNullPredicate implements java.util.function.Predicate<Order> {

    @Override
    public boolean test(Order order) {
        return order != null;
    }
}