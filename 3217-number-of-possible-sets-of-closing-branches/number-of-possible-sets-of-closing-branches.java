class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int count = 0;

        for (int i = 1; i <= (1 << n); i++) {
            List<Integer> branches = new ArrayList<>();
            int[][] dist = new int[n][n];

            for (int[] arr : dist) Arrays.fill(arr, (int)1e9);

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    branches.add(j);
                }
                dist[j][j] = 0;
            }

            

            for (int[] road : roads) {
                int u = road[0], v = road[1], d = road[2];

                if ((i & (1 << u)) != 0 && (i & (1 << v)) != 0) {
                    dist[u][v] = dist[v][u] = Math.min(d, dist[u][v]);
                }
            }

            for (int k1 = 0; k1 < n; k1++) {
                for (int k2 = 0; k2 < n; k2++) {
                    for (int k3 = 0; k3 < n; k3++) {
                        dist[k2][k3] = Math.min(dist[k2][k3], dist[k2][k1] + dist[k1][k3]);
                    }
                }
            }

            int isFeasible = 1;

            for (int u : branches) {
                for (int v : branches) {
                    if (dist[u][v] > maxDistance) {
                        isFeasible = 0;
                        break;
                    }
                }
            }

            if (isFeasible == 1) {
                System.out.println(branches);
            }

            count += isFeasible;
        }

        return count;
    }
}