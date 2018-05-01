package barBossHouse;

public class Order {

    private int size;
    private Dish[] dishes;

    public Order() {
        dishes = new Dish[16];
        size = 0;
        //todo: а за размером кто будет следить?)
        //сделала
    }

    public Order(int newSize) {
        size = newSize;
        dishes = new Dish[newSize];
    }

    public Order(Dish[] newDishes) {
        //todo: и здесь размер не меняется
        //сделала
        dishes = newDishes;
        size = dishes.length;
    }

    public boolean addDishInOrder(Dish dish) {
        //todo: а если больше 16 элементо в массиве? Ты должна ходить до size. И НЕ здесь.
        //todo: ты должна проверить, если size меньше длины массива, то добавлешь элемент с индексом равному size новый диш
        //todo: если нет, то увеличиваешь массив в два раза, копируешь элементы с помощью System.arraycopy и уже тогда добавляешь
        //сделала
        for (int i = 0; i < 16; i++) {
            if (dishes[i] == null) {
                dishes[i] = dish;
                return true;
            }
        }
        Dish[] arr = new Dish[dishes.length*2];
        System.arraycopy(dishes, 0, arr, dishes.length, dishes.length);
        arr[size] = dish;
        dishes = arr;
        return true;
    }

    public boolean removeDishInOrder(String nameDish) {
        for (int i = 0; i < size; i++) {
            if (dishes[i].getName().equals(nameDish)) {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                size--;
                i--;
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

    //todo: ты здесь должна вернуть массив без null-ов
    //в методе remove и так без дырок все делается )))
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
    //про null-ы - все в remove

    public String[] dishesNames() {
        int count = 0;
        String[] dishesNames = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(dishes[i].getName().equals(dishesNames[j])) {
                    break;
                }
                else { dishesNames[count++] = dishes[i].getName();}
            }
        }
        return dishesNames;
    }

    public Dish[] sortedDishesByCostDesc() {
        //todo: ты должна вернуть отсортированную копию массива, а не менять состояние поля
        //сделала
        Dish temp;
        Dish[] dishes1 = new Dish[dishes.length];
        for (int i = 0; i < dishes1.length; i++) {
            for (int j = 0; j < dishes1.length - 1; j++) {
                if (dishes1[j].getCost() < dishes1[j + 1].getCost()) {
                    temp = dishes1[j];
                    dishes1[j] = dishes1[j + 1];
                    dishes1[j + 1] = temp;
                }
            }
        }
        return dishes;
    }
}