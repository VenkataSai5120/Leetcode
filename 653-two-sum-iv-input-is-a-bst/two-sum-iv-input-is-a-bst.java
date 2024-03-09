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
class BSTIterator {
    Stack<TreeNode> toFront;
    Stack<TreeNode> toBack;
    TreeNode front;
    TreeNode back;

    public BSTIterator(TreeNode root) {
        front = root;
        back = root;
        toFront = new Stack<>();
        toBack = new Stack<>();
    }

    public TreeNode next() {
        while (front != null) {
            toFront.add(front);
            front = front.left;
        }
        TreeNode node = toFront.pop();
        front = node.right;
        return node;
    }

    public boolean hasNext() {
        return front != null || !toFront.isEmpty();
    }

    public TreeNode prev() {
        while (back != null) {
            toBack.add(back);
            back = back.right;
        }
        TreeNode node = toBack.pop();
        back = node.left;
        return node;
    }

    public boolean hasPrev() {
        return back != null || !toBack.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator it = new BSTIterator(root);
        TreeNode front = it.next();
        TreeNode back = it.prev();

        while (front != back) {
            int sum = front.val + back.val;
            if (sum == k) {
                return true;
            } else if (sum > k) {
                back = it.prev();
            } else {
                front = it.next();
            }
        }

        return false;
    }
}
