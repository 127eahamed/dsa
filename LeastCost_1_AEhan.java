import java.util.ArrayList;

public class LeastCost_1_AEhan<E> {
    private final ArrayList<WeightedNode_1_AEhan<E>> nodes;

    public LeastCost_1_AEhan(E[] values, double[][] matrix) {
        nodes = new ArrayList<WeightedNode_1_AEhan<E>>();
        for (E value : values) {
            nodes.add(new WeightedNode_1_AEhan<E>(value));
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == Double.POSITIVE_INFINITY) {
                    continue;
                }
                nodes.get(row).connect(nodes.get(col), matrix[row][col]);
            }
        }
    }

    public WeightedPath_1_AEhan<E> leastCost(E start, E target) {
        WeightedNode_1_AEhan<E> startNode = null;
        WeightedNode_1_AEhan<E> targetNode = null;
        for (WeightedNode_1_AEhan<E> node : nodes) {
            if (node.getValue().equals(start)) {
                startNode = node;
            }
            if (node.getValue().equals(target)) {
                targetNode = node;
            }
        }
        if (startNode == null || targetNode == null) {
            return null;
        }
        return leastCost(startNode, targetNode, new WeightedPath_1_AEhan<E>(startNode), new WeightedPath_1_AEhan<E>());
    }

    private WeightedPath_1_AEhan<E> leastCost(
        WeightedNode_1_AEhan<E> current,
        WeightedNode_1_AEhan<E> target,
        WeightedPath_1_AEhan<E> path,
        WeightedPath_1_AEhan<E> best
    ) {
        if (path.isCompleted(target)) {
            return path.getCost() < best.getCost() ? path : best;
        }
        if (path.getCost() >= best.getCost()) {
            return best;
        }
        ArrayList<WeightedPath_1_AEhan<E>> bests = new ArrayList<WeightedPath_1_AEhan<E>>();
        for (WeightedNode_1_AEhan<E> node : current.getConnections()) {
            if (path.contains(node) && node != target) {
                continue;
            }
            bests.add(leastCost(node, target, new WeightedPath_1_AEhan<E>(path, node), best));
        }
        double bestCost = best.getCost();
        WeightedPath_1_AEhan<E> newBest = best;
        for (WeightedPath_1_AEhan<E> possibleBest : bests) {
            if (possibleBest.getCost() < bestCost) {
                newBest = possibleBest;
            }
        }
        return newBest;
    }
}
