package barBossHouse;



public class Listik<T> {

    private Node<T> head;
    private Node<T> tail;

    public int size;

    public Listik() {
        this.size = 0;
    }


//TODO Везде в локальных переменных во всех методах этого класса  надо Node<T> использовать тип, а не Node. Тогда и кастовать к Т не придется
    public T get(int index) {
        //Node y; //БЫЛО
        Node<T> y; //А надо так
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
        //todo а зачем тебе этот цикл, если у тебя tail есть?!?!?!?!
        for (int i = 0; i < size; i++) {
            y = x.next;
            x = y;
        }
        y.next = new Node(item);
        this.tail=y.next;
        y.next.prev=y;
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
        x.next.prev=x;
        size--;
    }

}
