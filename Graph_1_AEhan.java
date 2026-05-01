import java.util.ArrayList;

public class Graph_1_AEhan<E> {
    private ArrayList<GraphNode_1_AEhan<E>> nodes;

    public Graph_1_AEhan(E[] values, int[][] adjacencyMatrix) {
        nodes = new ArrayList<GraphNode_1_AEhan<E>>();
        for (E value : values) {
            nodes.add(new GraphNode_1_AEhan<E>(value));
        }
        for (int row = 0; row < adjacencyMatrix.length; row++) {
            for (int col = 0; col < adjacencyMatrix[0].length; col++) {
                if (adjacencyMatrix[row][col] == 1) {
                    nodes.get(row).addConnection(nodes.get(col));
                }
            }
        }
    }

    private void printPath(ArrayList<GraphNode_1_AEhan<E>> path, E value) {
        System.out.print(value);
        for (GraphNode_1_AEhan<E> node : path) {
            System.out.print(node.getValue());
        }
        System.out.println(value);
    }

    private void printPathCycles(GraphNode_1_AEhan<E> current, GraphNode_1_AEhan<E> end, ArrayList<GraphNode_1_AEhan<E>> path) {
        if (current == end) {
            printPath(path, end.getValue());
            return;
        }

        for (GraphNode_1_AEhan<E> node : current.getConnections()) {
            if (!path.contains(node)) {
                ArrayList<GraphNode_1_AEhan<E>> newPath = new ArrayList<GraphNode_1_AEhan<E>>(path);
                newPath.add(node);
                printPathCycles(node, end, newPath);
            }
        }
    }

    public void printCycles() {
        for (GraphNode_1_AEhan<E> node : nodes) {
            for (GraphNode_1_AEhan<E> child : node.getConnections()) {
                printPathCycles(child, node, new ArrayList<GraphNode_1_AEhan<E>>());
            }
        }
    }
}
