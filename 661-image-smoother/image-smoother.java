class Solution {
    public int[][] imageSmoother(int[][] img) {
        if (img == null) return null;
        
        int rows = img.length;
        if (rows == 0) return new int[0][];
        int cols = img[0].length;

        int[][] result = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;

                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if (isValid(r, c, rows, cols)) {
                            count++;
                            sum += img[r][c];
                        }
                    }
                }

                result[row][col] = sum / count;
            }
        }

        return result;
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
