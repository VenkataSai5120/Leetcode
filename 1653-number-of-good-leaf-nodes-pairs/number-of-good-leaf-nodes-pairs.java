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
    private int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }
    
    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }
        if (node.left == null && node.right == null) {
            int[] leafDistance = new int[distance + 1];
            leafDistance[1]++;
            return leafDistance;
        }
        int[] leftDistances = dfs(node.left, distance);
        int[] rightDistances = dfs(node.right, distance);

        for (int l = 0; l <= distance; l++) {
            for (int r = distance; r >= 0; r--) {
                if (l + r <= distance) {
                    result += leftDistances[l] * rightDistances[r];
                }
            }
        }
        
        int[] res = new int[distance + 1];
        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = leftDistances[i] + rightDistances[i];
        }

        return res;
    }
}
