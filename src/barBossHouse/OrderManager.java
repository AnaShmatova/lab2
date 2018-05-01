package barBossHouse;

import java.util.function.Predicate;

//todo: все ранние замечания справедливы для этого класса тоже.
//todo: буду ставить пустые //todo:
public class OrderManager {
    private Order[] orders;

    public OrderManager(int newTableNumber) {
        orders = new Order[newTableNumber];
    }

    public void add(Order order, int tableNumber) {
        orders[tableNumber - 1] = order;
    }

    public Order getOrder(int tableNumber) {
        return orders[tableNumber - 1];
    }

    public void addDish(Dish dish, int tableNumber) {
        orders[tableNumber - 1].addDishInOrder(dish);
    }

    public void removeOrder(int tableNumber) {
        orders[tableNumber - 1] = null;
    }
    //TODO: 2.05 добавь get к имени
    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            //TODO: 2.05 этот if будет всегда возвращать false
            if (orders[i].equals(null)) {
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
    public int[] predicateNoFreeTableNumbers(Predicate isP1) {
        return tableNumbers(new NotIsNullPredicate());
    }

    public int[] predicateFreeTableNumbers(Predicate isP1) {
        return tableNumbers(new IsNullPredicate());
    }

    public Order[] getOrders() {
        //todo: очень плохое имя для переменной
        //сделала
        //TODO: 2.05 аэм. вызывать метод для свободных столиков, чтобы передать не-null предикат?оО
        int[] table = predicateFreeTableNumbers(new NotIsNullPredicate());
        Order[] atTheMomentOrders = new Order[table.length];
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