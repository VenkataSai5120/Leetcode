class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        
        // Check if the path starts at the current root node or its children
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // This function checks if a path matching the linked list exists starting at the given tree node
    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // Reached the end of the linked list, path found
        }
        if (root == null) {
            return false; // Reached the end of the tree but the list is not yet fully matched
        }
        // Check if the current values match and continue the search downwards
        if (root.val == head.val) {
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        return false; // Values don't match, this path is invalid
    }
}
