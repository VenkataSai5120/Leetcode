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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] depthAndParA = findDepthAndPar(root, x, -1);
        int[] depthAndParB = findDepthAndPar(root, y, -1);

        if (depthAndParA[0] == depthAndParB[0] && depthAndParA[1] != depthAndParB[1]) {
            return true;
        }

        return false;
    }

    private int[] findDepthAndPar(TreeNode root, int val, int par) {
        if (root == null) {
            return new int[] {-1, -1};
        }

        if (root.val == val) {
            System.out.println(par);
            return new int[] {0, par};
        }
        int[] d1 = findDepthAndPar(root.left, val, root.val);
        if (d1[0] >= 0) {
            return new int[] {d1[0] + 1, d1[1]};
        }

        int[] d2 = findDepthAndPar(root.right, val, root.val);
        if (d2[0] >= 0) {
            return new int[] {d2[0] + 1, d2[1]};
        }

        return new int[] {-1, -1};

    }
}