package barBossHouse;

public class Order {
    private int size;
    private Dish[] dishes;

    public Order() {
        dishes = new Dish[16];
        //todo: а за размером кто будет следить?)
    }

    public Order(int newSize) {
        size = newSize;
        dishes = new Dish[newSize];
    }

    public Order(Dish[] newDishes) {
        //todo: и здесь размер не меняется
        dishes = newDishes;
    }

    public boolean addDishInOrder(Dish dish) {
        //todo: а если больше 16 элементо в массиве? Ты должна ходить до size. И НЕ здесь.
        //todo: ты должна проверить, если size меньше длины массива, то добавлешь элемент с индексом равному size новый диш
        //todo: если нет, то увеличиваешь массив в два раза, копируешь элементы с помощью System.arraycopy и уже тогда добавляешь
        for (int i = 0; i < 16; i++) {
            if (dishes[i] == null) {
                dishes[i] = dish;
                return true;
            }
        }
        return false;
    }

    public boolean removeDishInOrder(String nameDish) {
        for (int i = 0; i < size; i++) {
            if (dishes[i].getName().equals(nameDish)) {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public int removeAll(String nameDish) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (dishes[i].getName().equals(nameDish)) {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                dishes[size--] = null;
                size--;
                i--;
                count++;
            }
        }
        return count;
    }

    public int dishQuantity() {
        return size;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public double costTotal() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += dishes[i].getCost();
        }
        return sum;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (dishes[i].getName().equals(dishName)) {
                count++;
            }
        }
        return count;
    }

    //todo: Тебе нужно вернуть массив имен без повторений и без null-ов в конце
    public String[] dishesNames() {
        String[] dishesNames = new String[size];
        for (int i = 0; i < size; i++) {
            dishesNames[i] = dishes[i].getName();
        }
        return dishesNames;
    }

    public Dish[] sortedDishesByCostDesc() {
        //todo: ты должна вернуть отсортированную копию массива, а не менять состояние поля
        Dish temp;
        for (int i = 0; i < dishes.length; i++) {
            for (int j = 0; j < dishes.length - 1; j++) {
                if (dishes[j].getCost() < dishes[j + 1].getCost()) {
                    temp = dishes[j];
                    dishes[j] = dishes[j + 1];
                    dishes[j + 1] = temp;
                }
            }
        }
        return dishes;
    }
}