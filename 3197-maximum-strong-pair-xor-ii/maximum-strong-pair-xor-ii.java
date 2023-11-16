class Trie {
    static final int MAX_B = 1 << 19;
    Trie[] p = new Trie[2];

    void insert(int n) {
        Trie r = this;
        for (int b = MAX_B; b > 0; b >>= 1) {
            int bit = (n & b) > 0 ? 1 : 0;
            if (r.p[bit] == null)
                r.p[bit] = new Trie();
            r = r.p[bit];
        }
    }

    boolean remove(int n, int b) {
        if (b == 0)
            return true;
        int bit = (n & b) > 0 ? 1 : 0;
        if (p[bit] != null && p[bit].remove(n, b >> 1)) {
            p[bit] = null;
        }
        return p[0] == null && p[1] == null;
    }

    int maxXor(int n) {
        int res = 0;
        Trie r = this;
        for (int b = MAX_B; b > 0; b >>= 1) {
            int bit = (n & b) > 0 ? 1 : 0;
            if (r.p[1 - bit] != null) {
                res += b;
                r = r.p[1 - bit];
            } else {
                r = r.p[bit];
            }
        }
        return res;
    }
}




class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Trie t = new Trie();
        Arrays.sort(nums);
        int res = 0, j = 0;
        for (int i = 0; i < nums.length; ++i) {
            t.insert(nums[i]);
            while (j < i && nums[j] * 2 < nums[i]) {
                t.remove(nums[j++], Trie.MAX_B);
            }
            res = Math.max(res, t.maxXor(nums[i]));
        }
        return res;
    }
}
