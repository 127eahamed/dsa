public class Node<E> {
    private E value;
    private Node<E> next;
    public Node(E initValue) {
        value = initValue;
        next = null;
    }
    public E getValue() {
        return value;
    }
    public void setValue(E newValue) {
        value = newValue;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> newNext) {
        next = newNext;
    }
}