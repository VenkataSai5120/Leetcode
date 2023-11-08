class Solution {
    Set<Integer> validDigits = new HashSet<>(Arrays.asList(0, 1, 2, 5, 6, 8, 9));
    public int rotatedDigits(int n) {
        String num = Integer.toString(n);
        int len = num.length();
        return findGood(num, 0, 0, 0, len);
    }

    private int findGood(String num, int index, int decider, int mask, int n) {
        if (index == n) {
            if((mask & (1 << 2)) != 0 || (mask & (1 << 5)) != 0 ||
            (mask & (1<<6)) != 0 || (mask & (1 << 9)) != 0) return 1;
            return 0;
        }

        int res = 0;
        int limit = decider == 0 ? num.charAt(index) - '0' : 9;

        for (int i = 0; i <= limit; i++) {
            if (!validDigits.contains(i)) {
                continue;
            }

            int newDecider = i < limit ? 1 : decider;
            res += findGood(num, index + 1, newDecider, mask | (1 << i), n);
        }

        return res;
    }
}