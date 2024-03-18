class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int numOfProvin = 0;
        
        for (int i = 0; i < n; i++) if (!visited[i]) {
            numOfProvin++;
            bfs(isConnected, i, visited, n);
        }
        
        return numOfProvin;
    }
    
    public void bfs(int[][] isConnected, int src, boolean[] visited, int n) {
        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while (!q.isEmpty()) {
            int city = q.poll();
            
            int adj;
            while ((adj = getAdjCity(isConnected, city, n, visited)) != -1) {
                visited[adj] = true;
                q.add(adj);
            }
        }
    }
    
    public int getAdjCity(int[][] isConnected, int city, int n, boolean[] visited) {
        for (int i =0; i < n; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) return i;
        }
        
        return -1;
    }
}