class Solution {
    public boolean isSubstringPresent(String s) {
        Map<Character, Set<Character>> map = new HashMap<>();
        
        // Populate the map
        for (int i = 1; i < s.length(); ++i) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            if (!map.containsKey(prev)) {
                map.put(prev, new HashSet<>());
            }
            map.get(prev).add(curr);
        }
        
        for (int i = 1; i < s.length(); ++i) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            if (map.containsKey(curr) && map.get(curr).contains(prev)) {
                return true;
            }
        }
        
        return false;
    }
}