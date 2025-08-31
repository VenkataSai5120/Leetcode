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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }

    private TreeNode construct(int postIndex, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        System.out.println(postIndex);

        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = map.get(postorder[postIndex]);
        root.left = construct(postIndex - 1 + index - inEnd, inStart, index - 1, inorder, postorder, map);
        root.right = construct(postIndex - 1, index + 1, inEnd, inorder, postorder, map);

        return root;
    }
}
