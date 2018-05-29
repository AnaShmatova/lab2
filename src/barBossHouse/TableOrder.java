package barBossHouse;

import java.time.LocalDateTime;

//todo дублирующиеся методы удали
//сделала
public class TableOrder implements Order {

    private int size;
    private MenuItem[] items;
    private Customer customer;
    private LocalDateTime timeOfOrder;

    public static final int EMPTY_VALUE = 0;
    public static final int SIZE_VALUE = 16;

    public TableOrder() {
        //todo вынести дефолтные знаения в константы
        items = new MenuItem[SIZE_VALUE];
        size = EMPTY_VALUE;
        this.timeOfOrder = LocalDateTime.now();
    }

    public TableOrder(int newSize, Customer customer) {

        if (newSize < 0)
            throw new NegativeSizeException("Number of elements is negative");

        size = 0;
        items = new MenuItem[newSize];
        this.customer = customer;
        this.timeOfOrder = LocalDateTime.now();
    }

    public TableOrder(MenuItem[] newDishes, Customer customer) {
        items = newDishes;
        size = items.length;
        this.customer = customer;
        this.timeOfOrder = LocalDateTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public LocalDateTime setDateOfOrder(LocalDateTime timeOfOrder) {
        return this.timeOfOrder = timeOfOrder;
    }

    @Override
    public LocalDateTime getDateOfOrder() {
        return timeOfOrder;
    }

    public boolean removeItemFromAnOrder(MenuItem item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                size--;
                items[size] = null;
                return true;
            }
        }
        return false;
    }

    public int removeItemsFromAnOrder(MenuItem itemS) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(itemS)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                items[size--] = null;
                size--;
                count++;
            }
        }
        return count;
    }

    public MenuItem[] getItems() {
        MenuItem[] copyItems = new MenuItem[size];
        System.arraycopy(items, 0, copyItems, 0, size);
        return copyItems;
    }

    public boolean add(MenuItem dish) {
        LocalDateTime now = LocalDateTime.now();
        if (size == items.length) {
            MenuItem[] arr = new MenuItem[items.length * 2];
            System.arraycopy(items, 0, arr, items.length, items.length);
            items = arr;
        }

        if (dish.getClass().getName().equals(Drink.class.getName()))
            if (now.getHour() > 22 && now.getHour() < 8 && now.getHour() > 0)
                throw new UnlawfulActionException("Time of sale of alcohol left");
        items[size] = dish;
        size++;
        return true;
    }

    public boolean remove(String nameDish) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(nameDish)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                items[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(item)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                size--;
                items[size] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    public int removeAll(String nameDish) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(nameDish)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                items[size--] = null;
                size--;
                i--;
                count++;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(item)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                items[size--] = null;
                size--;
                i--;
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }


    public MenuItem[] getDishes() {
        MenuItem[] arr = new MenuItem[size];
        System.arraycopy(items, 0, arr, 0, size);
        return arr;
    }

    public int costTotal() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    //todo массив имен без повторов
    //сделала
    @Override
    public String[] itemsNames() {
        int count = 0;
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (items[i].getName().equals(dishesNames()[j])) {
                    break;
                } else {

                }
            }
        }
        System.arraycopy(items, 0, arr, 0, size);
        return arr;


    }



      //  for (int i = 0; i < size; i++) {
      //      for (int j = 0; j < size; j++) {
      //          if (arr[i] != null && arr[j] != null && arr[i].equals(arr[j])) {  //Заменяет дубликаты на null Записывает колличество нулей в переменну nulls
      //              arr[j] = null;
      //              count++;
       //         }
       //     }
       // }
//        for (int i = size - 1; i >= 0; i--) {    //Выталкиват null в конец массива.
//            for (int j = 0; j < i; j++) {
//                if (arr[j] == null) {
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = null;
//                }
//            }
//        }
       // String[] result = new String[size - count];
      //  for (int i = 0; i < size; i++) {          //Удаляет нули.
       //     result[i] = arr[i];
       // }



    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem count = null;
        MenuItem[] arr = getDishes(); //todo вот так надо было делать
        /*MenuItem[] arr = new MenuItem[size];
        //сделала
        System.arraycopy(arr, 0, items, 0, size); */
        for (int k = 0; k < size - 1; k++) {
            for (int j = k + 1; j < size; j++) {
                if (arr[k].getCost() > arr[j].getCost()) {
                    count = arr[k];
                    arr[k] = arr[j];
                    arr[j] = count;
                }
            }
        }
        return arr;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(dishName)) {
                count++;
            }
        }
        return count;
    }

    public String[] dishesNames() {
        int count = 0;
        String[] dishesNames = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (items[i].getName().equals(dishesNames[j])) {
                    break;
                } else {
                    dishesNames[count] = items[i].getName();
                    count++;
                }
            }
        }
        String[] arr = new String[count];
        System.arraycopy(items, 0, arr, 0, count);
        return arr;
    }

    public MenuItem[] sortedDishesByCostDesc() {
        MenuItem temp;
        MenuItem[] dishes1 = new MenuItem[items.length];
        System.arraycopy(items, 0, dishes1, 0, items.length);
        for (int i = 0; i < dishes1.length; i++) {
            for (int j = 0; j < dishes1.length - 1; j++) {
                if (dishes1[j].getCost() < dishes1[j + 1].getCost()) {
                    temp = dishes1[j];
                    dishes1[j] = dishes1[j + 1];
                    dishes1[j + 1] = temp;
                }
            }
        }
        return dishes1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("TableOrder:").append(" ");
        string.append(this.size).append(" ");
        for (int i = 0; i < size; i++) {
            string.append(this.items[i]).append(",").append("\n");
        }
        return string.toString();
    }

    //todo исправить насчет equals, написать проверку на каждый лемент (fori)
    //сделала
    @Override
    public boolean equals(Object obj) {
        boolean condition = true;
        if (obj == null) {
            return false;
        }

        if (!(getClass() == obj.getClass()))
            return false;
        else {
            TableOrder comparison = (TableOrder) obj;
            //todo С каких это пор содержимое объектов оператором == сравнивается???
            if (comparison.customer.equals(this.customer) && comparison.size == this.size)
                for (int i = 0; i < items.length; i++) {
                    //todo почему это исключающее или?!?! объекты равны, если равны ВСЕ их блюда одновременно
                    condition &= comparison.items[i].equals(this.items[i]);
                }
        }
        return condition;
    }

    @Override
    public int hashCode() {
        //todo hashCode() массива левый. Нужно в цикле пробегаться по элементам и использовать их хэшкоды
        int a = customer.hashCode() ^ size;

        for (int i = 0; i < items.length; i++) {
            a ^= items[i].hashCode();
        }
        return a;
    }

}