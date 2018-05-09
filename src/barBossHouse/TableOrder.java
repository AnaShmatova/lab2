package barBossHouse;

public class TableOrder implements Order {

    private int size;
    private MenuItem[] items;
    private Customer customer;

    public TableOrder() {
        items = new MenuItem[16];
        size = 0;
        //todo: а за размером кто будет следить?)
        //сделала
    }

    public TableOrder(int newSize, Customer customer) {
        //TODO: 2.05 поле хранит реальный размер, а ты ему емкость передаешь. Вот и проблема именования всплыла))
        //сделала
        size = 0;
        items = new MenuItem[newSize];
        this.customer = customer;
    }

    public TableOrder(MenuItem[] newDishes, Customer customer) {
        //todo: и здесь размер не меняется
        //сделала
        items = newDishes;
        //TODO: 2.05 а вот здесь правильно
        size = items.length;
        this.customer = customer;

    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public boolean removeItemFromAnOrder(MenuItem item){
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
        for (int i = 0; i < size ; i++) {
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
        return items;
    }

    public boolean addDishInOrder(MenuItem dish) {
        //todo: а если больше 16 элементо в массиве? Ты должна ходить до size. И НЕ здесь.
        //todo: ты должна проверить, если size меньше длины массива, то добавлешь элемент с индексом равному size новый диш
        //todo: если нет, то увеличиваешь массив в два раза, копируешь элементы с помощью System.arraycopy и уже тогда добавляешь
        //сделала
        //TODO: 2.05 нифига не сделала) ниже может соглашусь, а на этот цикл никогда)
        //сделала
        items[size] = dish;
        if (size == 16) {
            MenuItem[] arr = new MenuItem[items.length * 2];
            System.arraycopy(items, 0, arr, items.length, items.length);
            arr[size] = dish;
            items = arr;
        }
        return true;
    }

    //TODO: 2.05 ты так упорно апеллировала к этому методу, что я нашел ошибку) Кто будет удалять последние элементы, раз они скопировались на позицию влево?)
    //сделала
    public boolean removeDishInOrder(String nameDish) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(nameDish)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                size--;
                items[size] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(MenuItem item) {
        items[size] = item;
        if (size == 16) {
            MenuItem[] arr = new MenuItem[items.length * 2];
            System.arraycopy(items, 0, arr, items.length, items.length);
            arr[size] = item;
            items = arr;
        }
        return true;
    }

    @Override
    public boolean remove(String itemName) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                System.arraycopy(items, i, items, i + 1, size - i - 1);
                size--;
                items[size] = null;
                i--;
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


    //todo: ты здесь должна вернуть массив без null-ов
    //в методе remove и так без дырок все делается )))
    //TODO: 2.05 а null-ы в конце ты не учитываешь?
    //сделала
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
        for (int i = 0; i < size ; i++) {
            if (items[i].equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(itemName)){
                count++;
            }
        }
        return count;
    }

    @Override
    public String[] itemsNames() {
        String[] arr = new String[size];
        for (int i = 0; i < size ; i++) {
            arr[i] = items[i].getName();
        }
        return arr;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem count = null;
        MenuItem[] arr = new MenuItem[size];
        for (int i = 0; i < size; i++) {
            arr[i] = items[i];
        }
        for (int k = 0; k < size-1 ; k++) {
            for (int j = k+1; j < size; j++) {
                if (arr[k].getCost()>arr[j].getCost()) {
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

    //todo: Тебе нужно вернуть массив имен без повторений и без null-ов в конце
    //про null-ы - все в remove
//TODO: 2.05 опять же, от null-ов в конце ты не избавляешься
    //сделала
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
        //todo: ты должна вернуть отсортированную копию массива, а не менять состояние поля
        //сделала
        MenuItem temp;
        //TODO: 2.05 имя так себе)
        MenuItem[] dishes1 = new MenuItem[items.length];
        System.arraycopy(items,0, dishes1, 0, items.length);
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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("TableOrder:").append(" ");
        string.append(this.size).append(" ");
        for (int i = 0; i < size ; i++) {
            string.append(this.items).append(",").append("\n");
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            TableOrder comparison = (TableOrder) obj;
            return comparison.customer == this.customer &&
                    comparison.size == this.size &&
                    comparison.equals(items);
        }
    }

    @Override
    public int hashCode() {
        return customer.hashCode()^size^items.hashCode();
    }

}