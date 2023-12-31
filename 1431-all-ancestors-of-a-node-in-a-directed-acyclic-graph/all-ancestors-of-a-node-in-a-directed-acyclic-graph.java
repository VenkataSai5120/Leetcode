class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        for (int i = 0; i < n; i++) {
            findAncestors(i, i, res, adj);
        }
        
        return res;
    }
    
    private void findAncestors(int x, int src, List<List<Integer>> res, List<List<Integer>> adj) {
        for (int node : adj.get(src)) {
            if (res.get(node).isEmpty() || res.get(node).get(res.get(node).size() - 1) != x) {
                res.get(node).add(x);
                findAncestors(x, node, res, adj);
            }
        }
    }
}
