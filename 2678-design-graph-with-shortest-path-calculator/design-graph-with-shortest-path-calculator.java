class Node {
    int v;
    int wt;
    Node(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Graph {
    int n;
    List<List<Node>> adj;
    public Graph(int n, int[][] edges) {
        this.n = n;
        this.adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Node(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Node(node1, 0));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
           for(Node it: adj.get(node.v)) {
                if(dist[node.v] + it.wt < dist[it.v]) {
                    dist[it.v] = dist[node.v] + it.wt; 
                    pq.add(new Node(it.v, dist[it.v]));
                }
            }
        }
        
        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */