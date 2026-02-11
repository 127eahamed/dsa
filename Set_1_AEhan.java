import java.util.ArrayList;

public class Set_1_AEhan<E> {
    private ArrayList<E> data;

    public Set_1_AEhan() {
        data = new ArrayList<E>();
    }
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        } else {
            data.add(e);
            return true;
        }
    }
    public boolean remove(E e) {
        return data.remove(e);
    }
    public void clear() {
        data = new ArrayList<E>();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public boolean contains(E e) {
        return data.contains(e);
    }
    public String toString() {
        return "{" + data.toString().substring(1, data.toString().length() - 1) + "}";
    }
}
