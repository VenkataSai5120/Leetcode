class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        long overAllScore = 0;
        int n = values.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            overAllScore += values[i];
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        long leavingScore = findLeavingScore(adj, 0, -1, values);
        return overAllScore - leavingScore;
    }

    private long findLeavingScore(List<List<Integer>> adj, int src, int par, int[] values) {
        long score = 0;

        for (int node : adj.get(src)) {
            if (node != par) {
                score += findLeavingScore(adj, node, src, values);
            }
        }

        if (score == 0) return values[src];
        return Math.min(values[src], score);
    }
}