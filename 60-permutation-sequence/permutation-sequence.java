class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        int f = 1;
        
        for (int i = 1; i < n; i++) {
            l.add(i);
            f *= i;
        }
        l.add(n);
        k--;
        StringBuilder res = new StringBuilder();

        while (true) {
            res.append(l.get(k / f));
            l.remove(k / f);
            if (l.size() == 0) break;
            k %= f;
            f /= l.size();
        }

        return res.toString();
    }
}