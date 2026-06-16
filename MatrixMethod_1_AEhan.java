public class MatrixMethod_1_AEhan {
//    private Matrix_1_AEhan matrix;
//    private int currLength;
//    private final String[] values;
//
//    public MatrixMethod_1_AEhan(String[] values, double[][] costs) {
//        matrix = new Matrix_1_AEhan(values.length);
//        for (int row = 0; row < costs.length; row++) {
//            for (int col = 0; col < costs[0].length; col++) {
//                matrix.set(row, col, costs[row][col], values[row]+values[col]);
//            }
//        }
//        currLength = 1;
//        this.values = values;
//        raise();
//    }
//    public double cost(String from, String to) {
//        int fromIndex = -1;
//        int toIndex = -1;
//        for (int index = 0; index < values.length; index++) {
//            if (from.equals(values[index])) {
//                fromIndex = index;
//            }
//            if (to.equals(values[index])) {
//                toIndex = index;
//            }
//            if (fromIndex != -1 && toIndex != -1) {
//                break;
//            }
//        }
//        return matrix.getCost(fromIndex, toIndex);
//    }
//    public String path(String from, String to) {
//        int fromIndex = -1;
//        int toIndex = -1;
//        for (int index = 0; index < values.length; index++) {
//            if (from.equals(values[index])) {
//                fromIndex = index;
//            }
//            if (to.equals(values[index])) {
//                toIndex = index;
//            }
//            if (fromIndex != -1 && toIndex != -1) {
//                break;
//            }
//        }
//        return matrix.getPath(fromIndex, toIndex);
//    }
//    private void raise() {
//        Matrix_1_AEhan newMatrix = new Matrix_1_AEhan(values.length);
//        for (int from = 0; from < values.length; from++) {
//            for (int to = 0; to < values.length; to++) {
//
//                double[] newCosts = new double[values.length];
//                for (int to2 = 0; to2 < values.length; to2++) {
//
//                }
//
//                int min = 0;
//                for (int to2 = 1; to2 < values.length; to2++) {
//                    if (matrix.getCost(to, to2) < newCosts[min]) {
//                        min = to2;
//                    }
//                }
//                if (matrix.getCost(from, to)+matrix.getCost(to, min) < matrix.getCost(from, to)) {
//                    newMatrix.set(from, to, newCosts[min], values[m]);
//                }
//
//            }
//        }
//        matrix = newMatrix;
//        currLength *= 2;
//        if (currLength < values.length || matrix.getLongestPath() < values.length) {
//            raise();
//        }
//    }
}
