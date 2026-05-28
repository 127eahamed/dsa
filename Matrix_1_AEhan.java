public class Matrix_1_AEhan {
    private double[][] costs;
    private String[][] paths;

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
    public static void main(String[] args) {
        Matrix_1_AEhan matrix = new Matrix_1_AEhan(4);
        matrix.set(0, 0, Double.POSITIVE_INFINITY, "AA");
        matrix.set(0, 1, 8.0, "AB");
        matrix.set(0, 2, Double.POSITIVE_INFINITY, "AC");
        matrix.set(0, 3, 2.0, "AD");
        matrix.set(1, 0, Double.POSITIVE_INFINITY, "BA");
        matrix.set(1, 1, Double.POSITIVE_INFINITY, "BB");
        matrix.set(1, 2, 5.0, "BC");
        matrix.set(1, 3, Double.POSITIVE_INFINITY, "BD");
        matrix.set(2, 0, 1.0, "CA");
        matrix.set(2, 1, Double.POSITIVE_INFINITY, "CB");
        matrix.set(2, 2, Double.POSITIVE_INFINITY, "CC");
        matrix.set(2, 3, 4.0, "CD");
        matrix.set(3, 0, Double.POSITIVE_INFINITY, "DA");
        matrix.set(3, 1, Double.POSITIVE_INFINITY, "DB");
        matrix.set(3, 2, Double.POSITIVE_INFINITY, "DC");
        matrix.set(3, 3, Double.POSITIVE_INFINITY, "DD");
        System.out.println(matrix);
    }
}
