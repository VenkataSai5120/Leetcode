public class Solution {
    public Pair<Long, Long> dfs(List<Integer>[] tree, int[] values, int node, int parent){
        long leftout = 0, taken = 0;

        for (int next : tree[node]) {
            if (next == parent) continue;
            Pair<Long, Long> result = dfs(tree, values, next, node);
            taken += result.getKey();
            leftout += result.getValue();
        }

        taken += (leftout != 0) ? Math.max(leftout, (long)values[node]) : 0;
        leftout = (leftout != 0) ? Math.min(leftout, (long)values[node]) : values[node];
        return new Pair<Long, Long>(taken, leftout);
    }

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        return dfs(tree, values, 0, -1).getKey();
    }
}
