import java.util.ArrayList;

public class WeightedNode_1_AEhan<E> {
    private ArrayList<WeightedNode_1_AEhan<E>> connections;
    private ArrayList<Double> costs;
    private final E value;

    public WeightedNode_1_AEhan(E value) {
        this.value = value;
    }

    public ArrayList<WeightedNode_1_AEhan<E>> getConnections() {
        return connections;
    }

    public E getValue() {
        return value;
    }

    public void connect(WeightedNode_1_AEhan<E> node, double cost) {
        int index = 0;
        while (index < connections.size()) {
            if (costs.get(index) > cost) {
                break;
            }
            index++;
        }
        if (index < connections.size()) {
            connections.add(index, node);
            costs.add(index, cost);
        } else {
            connections.add(node);
            costs.add(cost);
        }
    }

    public double getCost(WeightedNode_1_AEhan<E> node) {
        int index = connections.indexOf(node);
        return index >= 0 ? costs.get(index) : Double.POSITIVE_INFINITY;
    }
}
