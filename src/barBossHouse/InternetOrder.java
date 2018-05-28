package barBossHouse;


import java.time.LocalDateTime;

public class InternetOrder implements Order {

    private Listik<MenuItem> listochek;
    private Customer customer;
    private LocalDateTime timeOfOrder;

    public InternetOrder() {
        this.listochek = new Listik<MenuItem>();
        this.timeOfOrder = LocalDateTime.now();
    }

    public InternetOrder(MenuItem[] items, Customer customer){
        for (int i = 0; i < items.length ; i++) {
            listochek.add(items[i]);
        }
        this.customer = customer;
        this.timeOfOrder = LocalDateTime.now();
    }

    public boolean add (MenuItem item) {

        LocalDateTime now = LocalDateTime.now();

        if (now.getHour() > 22 || now.getHour() < 8 ) {
            throw new UnlawfulActionException("Time of sale of alcohol left");
        }

        listochek.add(item);
        return true;
    }

    public boolean remove (String itemName) {
        for (int i = 0; i < listochek.size; i++) {
            if(listochek.get(i).getName().equals(itemName)) {
                listochek.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean remove(MenuItem item) {
        for (int i = 0; i < listochek.size; i++) {
            if(listochek.get(i).equals(item)) {
                listochek.remove(i);
                return true;
            }
        }
        return false;
    }

    public int removeAll (String itemName) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if (listochek.get(i).getName().equals(itemName)){
                listochek.remove(i);
                i--; //todo эту строчку я добавил, ибо если ты удалила элемент, то нужно оставться на том же значении i
                count++;
            }
        }
        return count;
    }

    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if (listochek.get(i).equals(item)) {
                listochek.remove(i);
                count++;
                i--; //todo эту строчку я добавил, ибо если ты удалила элемент, то нужно оставться на том же значении i
            }
        }
        return count;
    }

    public int itemsQuantity() {
        return listochek.size;
    }

    public MenuItem[] getItems() {
        MenuItem[] arr = new MenuItem[listochek.size];
        for (int i = 0; i < listochek.size ; i++) {
            arr[i] = listochek.get(i);
        }
        return arr;
    }

    public int costTotal() {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            count+=listochek.get(i).getCost();
        }
        return count;
    }


    public int itemQuantity(String name) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if (listochek.get(i).getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    public int itemQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < listochek.size; i++) {
            if(listochek.get(i).equals(item)) {
                count++;
            }
        }
        return count;
    }

    public String[] itemsNames(){
        String[] arr = new String[listochek.size];
        for (int i = 0; i < listochek.size ; i++) {
            arr[i] = listochek.get(i).getName();
        }
        return arr;
    }

    public MenuItem[] sortedItemsByCostDesc() {
        //todo у тебя есть метод getItems(), который делает копию массива, вызывай его, не надо дублировать код
        //сделала
        MenuItem count = null;
        MenuItem[] arr = getItems();

        for (int k = 0; k < listochek.size-1 ; k++) {
            for (int j = k+1; j < listochek.size; j++) {
                if (arr[k].getCost()>arr[j].getCost()) {
                    count = arr[k];
                    arr[k] = arr[j];
                    arr[j] = count;
                }
            }
        }
        return arr;
    }


    public Customer getCustomer() {
        return customer;
    }

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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("InternetOrder:").append(customer.toString()).append("\n");
        string.append(this.listochek.size).append("\n");
        for (int i = 0; i < listochek.size ; i++) {
            string.append(this.listochek.get(i)).append(",").append("\n");
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
            InternetOrder comparison = (InternetOrder) obj;
            //todo С каких это пор содержимое объектов оператором == сравнивается???
            //сделала
            return comparison.customer.equals(customer) &&
                    comparison.listochek.equals(this.listochek);
            //todo где цикл на сравнение ээлементов списка? в предыдущей todoшке было же
        }
    }

    @Override
    public int hashCode() {
       int a = customer.hashCode();

        for (int i = 0; i <this.listochek.size ; i++) {
            a^=listochek.get(i).hashCode();
        }
        return a;
        //todo А где хэшкоды всей айтемов?
    }
}
