/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        createGraph(root, adj);
        
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Boolean> seen = new HashMap<>();
        q.offer(start);
        seen.put(start, true);

        int time = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                int node = q.poll();
                for (int i : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!seen.containsKey(i)) {
                        q.offer(i);
                        seen.put(i, true);
                    }
                }
            }
            time++;
        }
        return time - 1;
    }

    private void createGraph(TreeNode root, Map<Integer, List<Integer>> adj) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, -1));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int parent = pair.getValue();

            if (parent != -1) {
                adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(node.val);
                adj.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent);
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, node.val));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, node.val));
            }
        }
    }
}