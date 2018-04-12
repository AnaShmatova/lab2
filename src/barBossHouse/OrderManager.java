package barBossHouse;

//todo: все ранние замечания справедливы для этого класса тоже.
//todo: буду ставить пустые //todo:
public class OrderManager {
    private Order[] orders;
    private int tableNumber; //todo: что это такое? оО

    public OrderManager(int newTableNumber) {
        tableNumber = newTableNumber;
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

    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals(null)) {
                return i + 1;
            }
        }
        return -1;
    }

    //todo: И мы переписываем эти два метода ниже на использование предиката или паттерна Стратегия. Чтобы не допустить
    //todo: дублирования кода.
    public int[] freeTableNumbers() {
        int j = 0;
        int[] numberFreeTables = new int[tableNumber];
        for (int i = 0; i < orders.length; i++) {
            //todo: даже среда подсказывает, что эта проверка всегда будет false
            if (orders[i].equals(null)) {
                numberFreeTables[j] = i + 1;
            }
        }
        return numberFreeTables;
    }

    public int[] noFreeTableNumbers() {
        int j = 0;
        int[] numberNoFreeTables = new int[tableNumber];
        for (int i = 0; i < orders.length; i++) {
            //todo: а здесь всегда будет true
            if (!orders[i].equals(null)) {
                numberNoFreeTables[j] = i + 1;
                j++;
            }
        }
        return numberNoFreeTables;
    }

    public Order[] getOrders() {
        //todo: очень плохое имя для переменной
        int[] frtre = noFreeTableNumbers();
        Order[] atTheMomentOrders = new Order[frtre.length];
        for (int i = 0; i < frtre.length; i++) {
            atTheMomentOrders[i] = orders[frtre[i] - 1];
        }
        return atTheMomentOrders;
    }

    public double ordersCostSummary() {
        double sum = 0;
        for (int i = 0; i < tableNumber; i++) {
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
