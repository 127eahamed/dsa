import java.util.ArrayList;

public class GraphNode_1_AEhan<E> {
    private ArrayList<GraphNode_1_AEhan<E>> connections;
    private E value;

    public GraphNode_1_AEhan(E value) {
        this.connections = new ArrayList<GraphNode_1_AEhan<E>>();
        this.value = value;
    }

    public ArrayList<GraphNode_1_AEhan<E>> getConnections() {
        return connections;
    }

    public E getValue() {
        return value;
    }

    public void addConnection(GraphNode_1_AEhan<E> node) {
        connections.add(node);
    }
}
