import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Map_1_AEhan<K,V> {
    ArrayList<K> keys;
    ArrayList<V> values;

    public Map_1_AEhan() {
        keys = new ArrayList<K>();
        values = new ArrayList<V>();
    }
    public Set<K> getKeys() {
        return new HashSet<K>(keys);
    }
    public void clear() {
        keys.clear();
        values.clear();
    }
    public boolean add(K key, V value) {
        if (keys.contains(key)) {
            return false;
        }
        keys.add(key);
        values.add(value);
        return true;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found");
        }
        keys.remove(index);
        return values.remove(index);
    }
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found");
        }
        return values.get(index);
    }
    public V set(K key, V value) {
        int index = keys.indexOf(key);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found");
        }
        return values.set(index, value);
    }
    public int size() {
        return keys.size();
    }
    public String toString() {
        String result = "{\n";
        for (int index = 0; index < keys.size(); index++) {
            result += "    " + keys.get(index) + ": " + values.get(index) + "\n";
        }
        return result + "}";
    }
}
