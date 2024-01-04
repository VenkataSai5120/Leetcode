class Solution {
    public int maximumScore(int a, int b, int c) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        // pq.add(a);
        // pq.add(b);
        // pq.add(c);
        // int res = 0;

        // while (pq.size() >= 2) {
        //     res++;
        //     int top1 = pq.poll();
        //     int top2 = pq.poll();
        //     top1--;
        //     top2--;
        //     if (top1 > 0) pq.add(top1);
        //     if (top2 > 0) pq.add(top2);
        // }

        // return res;

        if (a < b) return maximumScore(b, a, c);
        if (b < c) return maximumScore(a, c, b);
        return b == 0 ? 0 : 1 + maximumScore(a - 1, b - 1, c);
    }
}