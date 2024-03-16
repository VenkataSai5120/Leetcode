class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(bank));
        Queue<List> q = new LinkedList<>();
        List l = Arrays.asList(start, 0);
        q.add(l);
        char[] pos = {'A', 'C', 'G', 'T'};
        set.remove(start);
        
        while (!q.isEmpty()) {
            l = q.poll();
            String s = (String) l.get(0);
            int len = (int) l.get(1);
            
            if (s.equals(end)) return len;
            
            char[] arr = s.toCharArray();
            
            for (int i = 0; i < 8; i++) {
                char real = arr[i];
                
                for (char c : pos) {
                    arr[i] = c;
                    if (set.contains(String.valueOf(arr))) {
                        l = Arrays.asList(String.valueOf(arr), len + 1);
                        q.add(l);
                        set.remove(String.valueOf(arr));
                    }
                }
                
                arr[i] = real;
            }
        }
        
        return -1;
    }
}