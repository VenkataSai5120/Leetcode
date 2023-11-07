class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = speed.length;
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(dist[i] * 1.0 / speed[i]);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            double monster = pq.poll();
            if (monster <= time) return n - pq.size() - 1;
            time++;
        }

        return n;
    }
}