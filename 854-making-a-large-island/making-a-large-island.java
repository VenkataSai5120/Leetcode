class DisjointSet {
    int[] par;
    int[] size;

    public DisjointSet(int n) {
        this.par = new int[n];
        this.size = new int[n];
        Arrays.fill(this.size, 1);

        for (int i = 0; i < n; i++) {
            this.par[i] = i;
        }
    }

    public void union(int u, int v) {
        u = findPar(u);
        v = findPar(v);

        if (u == v) return;

        if (size[u] < size[v]) {
            size[v] += size[u];
            par[u] = v;
        }
        else if (size[u] > size[v]) {
            size[u] += size[v];
            par[v] = u;
        }
        else {
            size[u] += size[v];
            par[v] = u;
        }
    }
    
    public int findPar(int n) {
        if (n == par[n]) return n;
        return par[n] = findPar(par[n]);
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int[] dx = {-1, 0, 1, 0};
                int[] dy = {0, -1, 0, 1};

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (Math.min(x, y) >= 0 && x < n && y < n && grid[x][y] == 1) {
                        ds.union(i * n + j, x * n + y);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int[] dx = {-1, 0, 1, 0};
                int[] dy = {0, -1, 0, 1};
                Set<Integer> set = new HashSet<>();
                int size = 1;

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (Math.min(x, y) >= 0 && x < n && y < n && grid[x][y] == 1 && !set.contains(ds.findPar(x * n + y))) {
                        set.add(ds.findPar(x * n + y));
                        size += ds.size[ds.findPar(x * n + y)];
                    }
                }

                max = Math.max(max, size);
            }
        } 

        for (int i = 0; i < n * n; i++) max = Math.max(max, ds.size[ds.findPar(i)]);

        return max;

    }
}