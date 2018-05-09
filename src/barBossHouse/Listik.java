package barBossHouse;

public class Listik<T> {

    private Listik<T> head;
    private Listik<T> tail;
    private T value;
    public int size;

    public Listik() {
        this.size = 0;
    }

    public Listik(T item) {
        this.value = item;
    }

    public T get(int index) {
        Listik y;
        Listik x = this; //указывает, что это первый элемент
        for (int i = 0; i < index; i++) {
            y = x.tail; //ссылка следующего элемента
            x = y;
        }
        return value;
    }

    public void add(T item) {
        Listik x = this;
        Listik y = null;
        for (int i = 0; i < size; i++) {
            y = x.tail;
            x = y;
        }
        y.tail = new Listik(item);
        size++;
    }

    public void remove(int index) {
        Listik x = this;
        Listik y;
        for (int i = 0; i < index-1; i++) {
            y = x.tail;
            x = y;
        }
        x.tail = x.tail.tail;
    }

}
