class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int ct = 1;
        int[] vis = new int[n];
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, ct, vis, res, edges);
            }
        }
        
        return res;
    }
    
    private int dfs(int node, int ct, int[] vis, int[] res, List<Integer> edges) {
        if (res[node] != 0) {
            return node;
        }

        if (vis[node] != 0) {
            res[node] = ct - vis[node];
            return node;
        }

        vis[node] = ct;
        ct += 1;
        int v = res[edges.get(node)];

        if (v != 0) {
            res[node] = 1 + v;
            return node;
        }

        int end = dfs(edges.get(node), ct, vis, res, edges);
        v = res[edges.get(node)];
        res[node] = v;

        if (vis[node] < vis[end]) {
            res[node] += 1;
        }
        
        return end;
    }
}
