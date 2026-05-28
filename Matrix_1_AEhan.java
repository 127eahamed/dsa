public class Matrix_1_AEhan {
    private final double[][] costs;
    private final String[][] paths;

    public Matrix_1_AEhan(int numNodes) {
        costs = new double[numNodes][numNodes];
        paths = new String[numNodes][numNodes];
    }

    public void set(int row, int col, double cost, String path) {
        costs[row][col] = cost;
        paths[row][col] = path;
    }
    public double getCost(int row, int col) {
        return costs[row][col];
    }
    public String getPath(int row, int col) {
        return paths[row][col];
    }
    public int getLongestPath() {
        int longest = -1;
        for (String[] row : paths) {
            for (String path : row) {
                if (path != null && path.length() - 1 > longest) {
                    longest = path.length() - 1;
                }
            }
        }
        return longest;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < costs.length; row++) {
            char from = paths[row][0].charAt(0);
            for (int col = 0; col < costs[0].length; col++) {
                String path = getPath(row, col);
                char to = path.charAt(path.length() - 1);
                result.append(from).append(" To ").append(to).append(" takes the route: ")
                    .append(path).append(" with a cost of ").append(getCost(row, col)).append("\n");
            }
            result.append("\n\n");
        }
        return result.toString();
    }
}
