class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] row = new int[rows];
        int[] col = new int[cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        int[][] diff = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                diff[i][j] = 2 * row[i] + 2 * col[j] - rows - cols;
            }
        }

        return diff;
    }
}
