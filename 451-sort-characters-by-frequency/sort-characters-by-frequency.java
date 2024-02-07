class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = 
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        return make(pq);
    }

    public String make(PriorityQueue<Map.Entry<Character, Integer>> pq) {
        var s = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> map = pq.poll();
            char c = map.getKey();
            int val = map.getValue();
            s.append(("" + c).repeat(val));
        }

        return s.toString();
    }
}