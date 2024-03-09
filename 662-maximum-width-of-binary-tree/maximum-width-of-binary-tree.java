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
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int first = q.peek().getValue(), last = q.peek().getValue();

            while (size-- > 0) {
                Pair<TreeNode, Integer> node = q.poll();
                int index = node.getValue();
                System.out.println(index);
                last = node.getValue();

                if (node.getKey().left != null) q.add(new Pair<>(node.getKey().left, 2 * index + 1));
                if (node.getKey().right != null) q.add(new Pair<>(node.getKey().right, 2 * index + 2));
            }

            res = Math.max(res, last - first + 1);
        }

        return res;
    }
}