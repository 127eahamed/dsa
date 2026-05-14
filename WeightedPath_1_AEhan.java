import java.util.ArrayList;

public class WeightedPath_1_AEhan<E> {
    private ArrayList<WeightedNode_1_AEhan<E>> nodes;
    private final double cost;

    public WeightedPath_1_AEhan() {
        cost = Double.POSITIVE_INFINITY;
    }

    public WeightedPath_1_AEhan(WeightedNode_1_AEhan<E> node) {
        nodes = new ArrayList<WeightedNode_1_AEhan<E>>();
        nodes.add(node);
        cost = 0;
    }

    public WeightedPath_1_AEhan(WeightedPath_1_AEhan<E> path, WeightedNode_1_AEhan<E> node) {
        this.nodes = new ArrayList<WeightedNode_1_AEhan<E>>(path.nodes);
        nodes.add(node);
        cost = path.getCost() + path.getLast().getCost(node);
    }

    public WeightedNode_1_AEhan<E> getLast() {
        return nodes.getLast();
    }

    public double getCost() {
        return cost;
    }

    public boolean isCompleted(WeightedNode_1_AEhan<E> target) {
        return !nodes.isEmpty() && getLast().equals(target);
    }

    public boolean contains(WeightedNode_1_AEhan<E> target) {
        return nodes.contains(target);
    }

    public String toString() {
        String result = "";
        for (WeightedNode_1_AEhan<E> node : nodes) {
            result += node.getValue();
        }
        result += " with a cost of " + getCost();
        return result;
    }
}
