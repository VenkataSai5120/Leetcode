class Solution {
    int[] dx = { +1, +1, 0, -1, -1, -1, 0, +1 };
    int[] dy = { 0, +1, +1, +1, 0, -1, -1, -1 };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        changeState(board, 0, 0, m, n);
    }

    private void changeState(int[][] board, int i, int j, int m, int n) {
        if (j == n) {
            i++;
            j = 0;
            if (i == m) {
                return;
            }
        }

        int nextGen = countAlive(board, i, j, m, n);
        changeState(board, i, j + 1, m, n);
        if (nextGen > 3 || nextGen < 2) {
            board[i][j] = 0;
        } else if (nextGen == 3) {
            board[i][j] = 1;
        }
    }

    private int countAlive(int[][] board, int i, int j, int m, int n) {
        int alive = 0;

        for (int k = 0; k < 8; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (Math.min(x, y) < 0 || x >= m || y >= n) continue;
            if (board[x][y] == 1) alive++;
        }

        return alive;
    }
}