class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> cs = new ArrayList<>();
        findCSI(candidates, target, 0, cs, new ArrayList<>(), candidates.length);
        return cs;
    }
    
    public void findCSI(int[] can, int target, int index, List<List<Integer>> cs, List<Integer> ds, int n) {
        
        if (n == index) {
            if (target == 0) cs.add(new ArrayList<Integer>(ds));
            return;
        }
        
        if (target == 0) {
            cs.add(new ArrayList<Integer>(ds));
            return;
        }
        
        if (can[index] <= target) {
            ds.add(can[index]);
            findCSI(can, target - can[index], index, cs, ds, n);
            ds.remove(ds.size() - 1);
        }
        
        findCSI(can, target, index + 1, cs, ds, n);
    }
}