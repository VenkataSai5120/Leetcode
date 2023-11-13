class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] arr = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));        
    
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (vowels.contains(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                arr[i] = '*';
            }
        }
        
        int index = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int count = m.getValue();
            
            while (count > 0) {
                if (arr[index] == '*') {
                    arr[index] = key;
                    count--;
                }
                index++;
            }
        }
        
        return  new String(arr);
    }
}