/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if (node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] tree = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < tree.length; i++) {
            TreeNode par = q.poll();
            
            if (!tree[i].equals("n")) {
                par.left = new TreeNode(Integer.parseInt(tree[i]));
                q.add(par.left);
            }

            if (!tree[++i].equals("n")) {
                par.right = new TreeNode(Integer.parseInt(tree[i]));
                q.add(par.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));