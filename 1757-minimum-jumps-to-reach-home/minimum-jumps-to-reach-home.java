class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> vis = new HashSet<>();
        for (int ele : forbidden) {
            vis.add(ele);
        }
        return findMinJumps(a, b, x, vis);
    }

    private int findMinJumps(int a, int b, int x, Set<Integer> vis) {
        int minJumps = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 1});
        vis.add(0);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] details = q.poll();
                int pos = details[0];
                int flag = details[1];

                if (x == pos) {
                    return minJumps;
                }

                // if (vis.contains(pos)) {
                //     continue;
                // }

                // vis.add(pos);

                if (pos - b >= 0 && flag == 1 && !vis.contains(pos - b)) {
                    q.add(new int[] {pos - b, 0});
                    vis.add(pos - b);
                }

                if (pos - b <= 2000 && !vis.contains(pos + a)) {
                    q.add(new int[] {pos + a, 1});
                    vis.add(pos + a);
                }
            }

            minJumps++;
        }

        return -1;
    }
}