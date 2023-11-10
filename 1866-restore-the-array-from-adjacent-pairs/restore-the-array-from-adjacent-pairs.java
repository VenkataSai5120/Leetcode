class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int start = adjacentPairs[0][0];

        for (int[] pair : adjacentPairs) {
            int id1 = indegree.getOrDefault(pair[0], 0) + 1;
            int id2 = indegree.getOrDefault(pair[1], 0) + 1;
            indegree.put(pair[0], id1);
            indegree.put(pair[1], id2);
            adj.computeIfAbsent(pair[0], val -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], val -> new ArrayList<>()).add(pair[0]);
        }

        for (Map.Entry<Integer, Integer> map : indegree.entrySet()) {
            if (map.getValue() == 1) {
                start = map.getKey();
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        dfs(adj, start, vis, res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int src, 
    Set<Integer> vis, List<Integer> res) {
        vis.add(src);
        res.add(src);

        for (int next : adj.getOrDefault(src, new ArrayList<>())) {
            if (!vis.contains(next)) {
                dfs(adj, next, vis, res);
            }
        }
    }
}