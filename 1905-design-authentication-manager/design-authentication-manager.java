class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> manager;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.manager = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        manager.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!manager.containsKey(tokenId) || manager.get(tokenId) <= currentTime) return;
        manager.put(tokenId, currentTime + timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int countAlive = 0;

        Iterator<Map.Entry<String, Integer>> iterator = manager.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int expireTime = entry.getValue();
            if (expireTime <= currentTime) {
                iterator.remove(); 
            } else {
                countAlive++;
            }
        }

        return countAlive;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */