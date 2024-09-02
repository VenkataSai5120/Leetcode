import java.util.*;

class Solution {
    long ans;
    List<Long> fact;
    Map<String, Integer> vis;

    public Solution() {
        fact = new ArrayList<>();
        vis = new HashMap<>();
    }

    String genpal(long num, long val) { 
        String s = Long.toString(num);
        String t = s.substring(0, (int) val);
        StringBuilder sb = new StringBuilder(t);
        t = sb.reverse().toString();
        s += t;
        return s;
    }

    boolean check(String s, int k) {
        long val = Long.parseLong(s);
        return val % k == 0;
    }

    long count(String s) { 
        long[] fr = new long[10];
        long n = s.length();

        if (n == 1) return 1;

        for (int i = 0; i < s.length(); ++i) {
            long curr = s.charAt(i) - '0';
            fr[(int) curr]++;
        }

        long tot = fact.get((int) n);
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < fr.length; ++i) {
            long curr = fr[i];
            str.append((char) ('a' + curr));
            tot /= fact.get((int) curr);
        }

        if (vis.containsKey(str.toString())) 
            return 0;

        vis.put(str.toString(), 1);

        if (fr[0] == 0) return tot;

        long a = fact.get((int) (n - 1));
        a /= fact.get((int) (fr[0] - 1));

        for (int i = 1; i < fr.length; ++i) {
            long curr = fr[i];
            a /= fact.get((int) curr);
        }

        long res = tot - a;
        return res;
    }

    void find(int pos, int num, int len, int stat, int k) {
        if (pos == len) {
            long val;

            if (stat == 1)
                val = len - 1;
            else
                val = len;

            String s = genpal(num, val); 
            boolean st = check(s, k);

            if (st)
                ans += count(s);

            return;
        }

        if (pos == 0) {
            for (int i = 1; i <= 9; ++i) {
                int tnum = num * 10 + i;
                find(pos + 1, tnum, len, stat, k);
            }
        } else {
            for (int i = 0; i <= 9; ++i) {
                int tnum = num * 10 + i;
                find(pos + 1, tnum, len, stat, k);
            }
        }
    }

    public long countGoodIntegers(int n, int k) {
        long len;
        ans = 0;
        int stat;

        fact.clear();
        vis.clear();

        fact.add(1L);
        long curr = 1;

        for (long i = 1; i <= 11; ++i) {
            curr = curr * i;
            fact.add(curr);
        }

        System.out.println(fact);

        if (n % 2 == 1) {
            len = n / 2 + 1;
            stat = 1;
        } else {
            len = n / 2;
            stat = 0;
        }

        find(0, 0, (int) len, stat, k);
        return ans;
    }
}
