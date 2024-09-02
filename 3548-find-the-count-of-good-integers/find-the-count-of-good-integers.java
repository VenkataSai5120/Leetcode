import java.util.*;

class Solution {
    long ans;
    List<Long> fact;
    Map<String, Integer> vis;

    public Solution() {
        fact = new ArrayList<>();
        vis = new HashMap<>();
    }

    String genpal(long num, long val) { // Generating palindrome corresponding to the first half generated.
        String s = Long.toString(num);
        String t = s.substring(0, (int) val);
        StringBuilder sb = new StringBuilder(t);
        t = sb.reverse().toString();
        s += t;
        return s;
    }

    boolean check(String s, int k) { // Divisibility check.
        long val = Long.parseLong(s);
        return val % k == 0;
    }

    long count(String s) { // Using basic combinatorics to count all combinations.
        long[] fr = new long[10];
        long n = s.length();

        if (n == 1) return 1;

        for (int i = 0; i < s.length(); ++i) {
            long curr = s.charAt(i) - '0';
            fr[(int) curr]++;
        }

        long tot = fact.get((int) n);
        StringBuilder str = new StringBuilder(); // Digit frequency string.

        for (int i = 0; i < fr.length; ++i) {
            long curr = fr[i];
            str.append((char) ('a' + curr));

            if (curr != 0) tot /= fact.get((int) curr);
        }

        if (vis.containsKey(str.toString())) // Don't count numbers with the same digit frequency multiple times.
            return 0;

        vis.put(str.toString(), 1);

        if (fr[0] == 0) return tot;

        long a = fact.get((int) (n - 1));
        a /= fact.get((int) (fr[0] - 1));

        for (int i = 1; i < fr.length; ++i) {
            long curr = fr[i];

            if (curr != 0) a /= fact.get((int) curr);
        }

        long res = tot - a;
        return res;
    }

    void find(int pos, int num, int len, int stat, int k) { // Generating all numbers of length len.
        if (pos == len) {
            long val;

            if (stat == 1) // stat = 0 => even n || stat = 1 => n is odd
                val = len - 1;
            else
                val = len;

            String s = genpal(num, val); // Generating palindrome.
            boolean st = check(s, k); // Check divisibility by k

            if (st) // If yes, count all possible combinations
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

        for (long i = 1; i <= 11; ++i) { // Corrected pre-computing factorial values for faster calculation.
            curr = curr * i;
            fact.add(curr);
        }

        if (n % 2 == 1) { // When n is odd, generate numbers of length (n/2 + 1).
            len = n / 2 + 1;
            stat = 1;
        } else { // When n is even, generate numbers of length n/2.
            len = n / 2;
            stat = 0;
        }

        find(0, 0, (int) len, stat, k);
        return ans;
    }
}
