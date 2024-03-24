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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0){
            int count = q.size();
            
            while (count > 0){
                TreeNode curr = q.poll();
                
                if (curr.left != null)
                    q.add(curr.left);
                
                if (curr.right != null)
                    q.add(curr.right);
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                count--;
            }
        }
        
        return root;
    }
}