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

class Group{
    TreeNode node;
    int ver, level;
    
    Group(TreeNode node, int ver, int level){
        this.node = node;
        this.ver = ver;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Group> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Group(root, 0, 0));
        while (!q.isEmpty()){
            int count = q.size();
            
            while (count > 0){
                Group g = q.poll();
                TreeNode node = g.node;
                int ver = g.ver;
                int level = g.level;
                
                TreeMap m = map.getOrDefault(ver, new TreeMap<Integer, PriorityQueue<Integer>>());
                PriorityQueue<Integer> in = (PriorityQueue<Integer>)m.getOrDefault(level, new PriorityQueue<Integer>());
                in.offer(node.val);
                m.put(level, in);
                map.put(ver, m);
                
                if (node.left != null) q.add(new Group(node.left, ver - 1, level + 1));
                if (node.right != null) q.add(new Group(node.right, ver + 1, level + 1));
                count--;
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> m : map.values()){
            List<Integer> l = new ArrayList<>();
            for (PriorityQueue<Integer> pq : m.values())
                while (!pq.isEmpty()) l.add(pq.poll());
            list.add(l);
        }
        
        return list;
    }
}