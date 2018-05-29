package barBossHouse;

public class Node<T> {

    public Node<T> prev;
    public Node<T> next;

    public T value;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() != (new Node(null)).getClass())
            return false;

        Node node = (Node) obj;


        if (this.value == node.value)
            return true;

        return false;
    }
}
