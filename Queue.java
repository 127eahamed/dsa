public class Queue<E> {
    private class QueueNode<E> {
        private E value;
        private QueueNode<E> next;

        public QueueNode(E value) {
            this.value = value;
        }

        public void setNext(QueueNode<E> next) {
            this.next = next;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public QueueNode<E> getNext() {
            return next;
        }
    }
    private QueueNode<E> oldest;
    private QueueNode<E> newest;

    public Queue() {
        oldest = null;
        newest = null;
    }

    public void enqueue(E value) {
        if(oldest == null) {
            oldest = new QueueNode<>(value);
            newest = oldest;
        } else {
            newest.setNext(new QueueNode<>(value));
            newest = newest.getNext();
        }
    }

    public E dequeue() {
        E temp = oldest.getValue();
        if(newest == oldest) {
            newest = null;
        }
        oldest = oldest.getNext();
        return temp;
    }

    public E peek() {
        return oldest.getValue();
    }

    public boolean isEmpty() {
        return oldest == null;
    }
}
