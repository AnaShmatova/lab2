package barBossHouse;



public class Listik<T> {

    private Node<T> head;
    private Node<T> tail;

    public int size;

    public Listik() {
        this.size = 0;
    }



    public T get(int index) {
        Node y;
        Node x = head; //указывает, что это первый элемент
        for (int i = 0; i < index; i++) {
            y = x.next; //ссылка следующего элемента
            x = y;
        }
        return (T) x.value;
    }

    public void add(T item) {
        Node x = head;
        Node y = null;
        if(size==0)
        {
            head.value = item;
            size++;
            return;
        }
        for (int i = 0; i < size; i++) {
            y = x.next;
            x = y;
        }
        y.next = new Node(item);
        size++;
    }

    public void remove(int index) {
        Node x = head;
        Node y;
        for (int i = 0; i < index-1; i++) {
            y = x.next;
            x = y;
        }
        x.next = x.next.next;
    }

}
