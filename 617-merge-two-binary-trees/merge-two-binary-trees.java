class TreeNodePair {
    TreeNode node1;
    TreeNode node2;

    public TreeNodePair(TreeNode node1, TreeNode node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        Stack<TreeNodePair> stack = new Stack<>();
        stack.push(new TreeNodePair(root1, root2));

        while (!stack.isEmpty()) {
            TreeNodePair tnp = stack.pop();

            if (tnp.node1 == null || tnp.node2 == null) {
                continue;
            }

            tnp.node1.val += tnp.node2.val;

            if (tnp.node1.left == null) {
                tnp.node1.left = tnp.node2.left;
            } else {
                stack.push(new TreeNodePair(tnp.node1.left, tnp.node2.left));
            }

            if (tnp.node1.right == null) {
                tnp.node1.right = tnp.node2.right;
            } else {
                stack.push(new TreeNodePair(tnp.node1.right, tnp.node2.right));
            }
        }

        return root1;
    }
}
