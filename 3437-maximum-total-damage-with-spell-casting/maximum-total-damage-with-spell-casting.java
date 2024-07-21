class Solution {
    private long getMaxDamage(long[] dp, Map<Integer, Integer> frequencyMap, 
    List<Integer> uniquePowers, int index) {
        if (index == uniquePowers.size()) return 0;
        if (dp[index] != -1) return dp[index];
        
        long skip = getMaxDamage(dp, frequencyMap, uniquePowers, index + 1);
        
        long take = 0;
        int nextIndex = index + 1;
        while (nextIndex < uniquePowers.size() && 
        uniquePowers.get(nextIndex) - uniquePowers.get(index) <= 2) {
            nextIndex++;
        }
        take = ((long) frequencyMap.get(uniquePowers.get(index)) * 
        uniquePowers.get(index)) + getMaxDamage(dp, frequencyMap, uniquePowers, nextIndex);
        
        dp[index] = Math.max(take, skip);
        return dp[index];
    }
    
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> uniquePowers = new ArrayList<>();
        
        for (int p : power) {
            frequencyMap.put(p, frequencyMap.getOrDefault(p, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            uniquePowers.add(key);
        }
        
        Collections.sort(uniquePowers);
        
        long[] dp = new long[frequencyMap.size()];
        Arrays.fill(dp, -1);
        
        return getMaxDamage(dp, frequencyMap, uniquePowers, 0);
    }
}
