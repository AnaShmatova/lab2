package barBossHouse;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.function.Predicate;

//todo: все ранние замечания справедливы для этого класса тоже.
//todo: буду ставить пустые //todo:
public class TableOrdersManager implements OrdersManager {
    private Order[] orders;
    private Order interfes;

    public TableOrdersManager(int newTableNumber) {
        orders = new TableOrder[newTableNumber];
    }

    public void add(TableOrder order, int tableNumber) {
        orders[tableNumber - 1] = order;
    }

    public TableOrder getOrder(int tableNumber) {
        return orders[tableNumber - 1];
    }

    public void addDish(MenuItem dish, int tableNumber) {
        orders[tableNumber - 1].addDishInOrder(dish);
    }

    public void removeOrder(int tableNumber) {
        orders[tableNumber - 1] = null;
    }
    //TODO: 2.05 добавь get к имени
    public int getFreeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            //TODO: 2.05 этот if будет всегда возвращать false
            //так?
            if (orders[i] == null) {
                return i + 1;
            }
        }
        return -1;
    }

    //todo: И мы переписываем эти два метода ниже на использование предиката или паттерна Стратегия. Чтобы не допустить
    //todo: дублирования кода.
    //сделала
    private int[] tableNumbers(Predicate isP) {
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
    //TODO: 2.05 ужос имена
    //Это не я так называла)) а Михаил Александрович ))
    public int[] predicateNoFreeTableNumbers(Predicate isP1) {
        return tableNumbers(new NotIsNullPredicate());
    }

    public int[] predicateFreeTableNumbers(Predicate isP1) {
        return tableNumbers(new IsNullPredicate());
    }

    public TableOrder[] getOrders() {
        //todo: очень плохое имя для переменной
        //сделала
        //TODO: 2.05 аэм. вызывать метод для свободных столиков, чтобы передать не-null предикат?оО
        //я запуталась, так как мне нуно было использовать метод noFreeTableNumbers (предыдущий метод),
        //но так как он состоит сейчас с предикатом я не знаю как его можно употребить здесь
        int[] table = predicateFreeTableNumbers(new NotIsNullPredicate());
        TableOrder[] atTheMomentOrders = new TableOrder[table.length];
        for (int i = 0; i < table.length; i++) {
            atTheMomentOrders[i] = orders[table[i] - 1];
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

    public int dishQuantity(String dishName) {
        int sum = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                sum += orders[i].dishQuantity(dishName);
            }
        }
        return sum;
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
        if (orders[i] = null;) {
            return tableNumbers(); //опять что то с предикатами
        }
        return -1;
    }

    public int removeAll(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].)
        }
    }



}

class IsNullPredicate implements java.util.function.Predicate<TableOrder> {

    @Override
    public boolean test(TableOrder order) {
        return order == null;
    }
}


class NotIsNullPredicate implements java.util.function.Predicate<TableOrder> {

    @Override
    public boolean test(TableOrder order) {
        return order != null;
    }
}