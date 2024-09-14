class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] cnt = new int[51][51];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);  

        pq.offer(new int[]{health - grid.get(0).get(0), 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], i = curr[1], j = curr[2];

            if (i == m - 1 && j == n - 1)
                return true;

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];

                if (x >= 0 && y >= 0 && x < m && y < n && cnt[x][y] < h - grid.get(x).get(y)) {
                    cnt[x][y] = h - grid.get(x).get(y);
                    pq.offer(new int[]{cnt[x][y], x, y});
                }
            }
        }

        return false;
    }
}
