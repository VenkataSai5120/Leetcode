class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;
        int size = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> innerList = nums.get(i);
            size += innerList.size();
            for (int j = 0; j < innerList.size(); j++) {
                int sum = i + j;
                List<Integer> list = map.getOrDefault(sum , new ArrayList<>());
                list.add(innerList.get(j));
                map.put(sum, list);
                maxKey = Math.max(maxKey, sum);
            }
        }
        
        int[] diagonalOrder = new int[size];
        int index = 0;
        for (int i = 0; i <= maxKey; i++) {
            List<Integer> diagonal = map.getOrDefault(i, new ArrayList<>());
            for (int x = diagonal.size() - 1; x >= 0; x--) {
                diagonalOrder[index++] = diagonal.get(x);
            }
        }
        
        return diagonalOrder;
    }
}
