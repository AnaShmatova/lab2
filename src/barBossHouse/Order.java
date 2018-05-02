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
        //TODO: 2.05 поле хранит реальный размер, а ты ему емкость передаешь. Вот и проблема именования всплыла))
        //сделала
        size = 0;
        dishes = new Dish[newSize];
    }

    public Order(Dish[] newDishes) {
        //todo: и здесь размер не меняется
        //сделала
        dishes = newDishes;
        //TODO: 2.05 а вот здесь правильно
        size = dishes.length;
    }

    public boolean addDishInOrder(Dish dish) {
        //todo: а если больше 16 элементо в массиве? Ты должна ходить до size. И НЕ здесь.
        //todo: ты должна проверить, если size меньше длины массива, то добавлешь элемент с индексом равному size новый диш
        //todo: если нет, то увеличиваешь массив в два раза, копируешь элементы с помощью System.arraycopy и уже тогда добавляешь
        //сделала
        //TODO: 2.05 нифига не сделала) ниже может соглашусь, а на этот цикл никогда)
        //сделала
        dishes[size] = dish;
        if (size == 16) {
            Dish[] arr = new Dish[dishes.length * 2];
            System.arraycopy(dishes, 0, arr, dishes.length, dishes.length);
            arr[size] = dish;
            dishes = arr;
        }
        return true;
    }

    //TODO: 2.05 ты так упорно апеллировала к этому методу, что я нашел ошибку) Кто будет удалять последние элементы, раз они скопировались на позицию влево?)
    //сделала
    public boolean removeDishInOrder(String nameDish) {
        for (int i = 0; i < size; i++) {
            if (dishes[i].getName().equals(nameDish)) {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                size--;
                dishes[size] = null;
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
    //TODO: 2.05 а null-ы в конце ты не учитываешь?
    //сделала
    public Dish[] getDishes() {
        Dish[] arr = new Dish[size];
        System.arraycopy(dishes, 0, arr, 0, size);
        return arr;
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
//TODO: 2.05 опять же, от null-ов в конце ты не избавляешься
    //сделала
    public String[] dishesNames() {
        int count = 0;
        String[] dishesNames = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dishes[i].getName().equals(dishesNames[j])) {
                    break;
                } else {
                    dishesNames[count] = dishes[i].getName();
                    count++;
                }
            }
        }
        String[] arr = new String[count];
        System.arraycopy(dishes, 0, arr, 0, count);
        return arr;
    }

    public Dish[] sortedDishesByCostDesc() {
        //todo: ты должна вернуть отсортированную копию массива, а не менять состояние поля
        //сделала
        Dish temp;
        //TODO: 2.05 имя так себе)
        Dish[] dishes1 = new Dish[dishes.length];
        System.arraycopy(dishes,0, dishes1, 0, dishes.length);
        for (int i = 0; i < dishes1.length; i++) {
            for (int j = 0; j < dishes1.length - 1; j++) {
                //TODO: 2.05 ты сортируешь пустой массив?) забавно
                if (dishes1[j].getCost() < dishes1[j + 1].getCost()) {
                    temp = dishes1[j];
                    dishes1[j] = dishes1[j + 1];
                    dishes1[j + 1] = temp;
                }
            }
        }
        //TODO: 2.05 и возвращаешь неотсортированное поле, отлично (нет)
        return dishes1;
    }
}