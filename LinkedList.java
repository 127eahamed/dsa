public class LinkedList<E> {
    private Node<E> head;
    int length;
    public LinkedList() {
        head = null;
        length = 0;
    }
    public void addFirst(E value) {
        if (length == 0) {
            head = new Node<E>(value);
            length++;
        } else {
            Node<E> newHead = new Node<E>(value);
            newHead.setNext(head);
            head = newHead;
            length++;
        }
    }
    public void addLast(E value) {
        if (length == 0) {
            addFirst(value);
            return;
        }
        Node<E> current = head;
        for (int i = 0; i < length - 1; i++) {
            current = current.getNext();
        }
        current.setNext(new Node<E>(value));
        length++;
    }
    public void add(int index, E value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == length) {
            addLast(value);
        } else if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<E> newNode = new Node<E>(value);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            length++;
        }
    }
    public int search(E value) {
        Node<E> current = head;
        for (int index = 0; index < length; index++) {
            if (current.getValue().equals(value)) {
                return index;
            }
            current = current.getNext();
        }
        return -1;
    }
    public E replace(int index, E value) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        E oldValue = current.getValue();
        current.setValue(value);
        return oldValue;
    }
    public int size() {
        return length;
    }
    public E removeFirst() {
        E oldHead = head.getValue();
        head = head.getNext();
        length--;
        return oldHead;
    }
    public E removeLast() {
        Node<E> current = head;
        for (int i = 0; i < length - 1; i++) {
            current = current.getNext();
        }
        E oldLast = current.getNext().getValue();
        current.setNext(null);
        length--;
        return oldLast;
    }
    public E remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            E oldValue = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            length--;
            return oldValue;
        }
    }
    public int remove(E value) {
        if (head.getValue().equals(value)) {
            removeFirst();
            return 0;
        }
        Node<E> current = head;
        for (int index = 0; index < length; index++) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                length--;
                return index;
            }
            current = current.getNext();
        }
        return -1;
    }
}