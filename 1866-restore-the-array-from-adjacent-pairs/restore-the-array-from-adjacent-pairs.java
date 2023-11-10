class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int start = adjacentPairs[0][0];

        for (int[] pair : adjacentPairs) {
            adj.computeIfAbsent(pair[0], val -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], val -> new ArrayList<>()).add(pair[0]);
        }

        for (Map.Entry<Integer, List<Integer>> map : adj.entrySet()) {
            if (map.getValue().size() == 1) {
                start = map.getKey();
                break;
            }
        }

        int[] result = new int[adj.size()];
        findOrder(adj, start, 1_000_000_007,result, 0);
        return result;
    }

    private void findOrder(Map<Integer, List<Integer>> adj, 
    int src, int par, int[] res, int index) {
        res[index] = src;

        for (int next : adj.getOrDefault(src, new ArrayList<>())) {
            if (next != par) {
                findOrder(adj, next, src, res, index + 1);
            }
        }
    }
}