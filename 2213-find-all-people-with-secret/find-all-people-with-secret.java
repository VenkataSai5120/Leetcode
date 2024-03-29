class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, firstPerson);
        int i = 0;
        while (i < meetings.length) {
            int curTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();
            while (i < meetings.length && curTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                unionFind.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }
            for (int j : pool) if (!unionFind.connected(0, j)) unionFind.reset(j);
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) if (unionFind.connected(j,0)) ans.add(j);
        return ans;
    }

    private static class UnionFind {
        int[] parent, rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
        
        public int find(int p) {
            while (parent[p] != p) p = parent[parent[p]];
            return p;
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
    }
}
