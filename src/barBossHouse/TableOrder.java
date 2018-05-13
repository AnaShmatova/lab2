package barBossHouse;

//todo дублирующиеся методы удали

public class TableOrder implements Order {

    private int size;
    private MenuItem[] items;
    private Customer customer;

    public TableOrder() {
        items = new MenuItem[16];
        size = 0;
    }

    public TableOrder(int newSize, Customer customer) {
        size = 0;
        items = new MenuItem[newSize];
        this.customer = customer;
    }

    public TableOrder(MenuItem[] newDishes, Customer customer) {
        items = newDishes;
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
//todo возвращай копию массива
    public MenuItem[] getItems() {
        return items;
    }

//correct
    public boolean add(MenuItem dish) {
        if (size == items.length) {
            MenuItem[] arr = new MenuItem[items.length * 2];
            System.arraycopy(items, 0, arr, items.length, items.length);
            items = arr;
        }
        items[size] = dish;
size++;
        return true;
    }
//correct
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
                i--;count++;
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
        for (int i = 0; i < size ; i++) {
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
            if (items[i].equals(itemName)){
                count++;
            }
        }
        return count;
    }

    //todo массив имен без повторов
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
        //todo arraycopy
        System.arraycopy();
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
        System.arraycopy(items,0, dishes1, 0, items.length);
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
        for (int i = 0; i < size ; i++) {
            string.append(this.items[i]).append(",").append("\n");
        }
        return string.toString();
    }

    //todo исправить насчет equals, написать проверку на каждый лемент (fori)
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
            if (comparison.customer == this.customer && comparison.size == this.size)
            for (int i = 0; i < items.length; i++) {
                comparison.equals(items);
            }

        }
        return equals((Object) obj);
    }

    @Override
    public int hashCode() {
        return customer.hashCode()^size^items.hashCode();
    }

}