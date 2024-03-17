class Solution {
    public int bfs(Set<Integer> vis, int a, int b, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});

        int ans = 0;
        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                int[] current = q.poll();
                int curr = current[0];
                int flag = current[1];

                if (curr == x) return ans;
                if (vis.contains(curr)) continue;

                vis.add(curr);
                if (flag == 1 && (curr - b >= 0)) q.offer(new int[]{curr - b, 0});

                if ((curr + a) <= 10000) q.offer(new int[]{curr + a, 1});
            }
            ans++;
        }
        return -1;
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> vis = new HashSet<>();
        for (int z : forbidden) vis.add(z);

        return bfs(vis, a, b, x);
    }
}