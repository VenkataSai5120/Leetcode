class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) adj.get(f[0]).add(new int[] {f[1], f[2]});

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, src, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1E9));
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int stops = arr[0];
            int u = arr[1];
            int d = arr[2];
            if (stops >= k + 1) continue;

            for (int[] l : adj.get(u)) {
                int v = l[0];
                int wt = l[1];

                if (wt + d < dist[v] && stops <= k) {
                    dist[v] = wt + d;
                    q.add(new int[] {stops + 1, v, dist[v]});
                }
            }
        }

        return dist[dst] == (int)(1E9) ? -1 : dist[dst];
    }
}