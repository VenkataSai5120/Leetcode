class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder();
        int n = shifts.length;
        long[] totalShifts = new long[n];
        totalShifts[n - 1] = shifts[n - 1];


        for (int i = n - 2; i >= 0; i--) {
            totalShifts[i] = totalShifts[i + 1] + shifts[i];
        }

        for (int i = 0; i < shifts.length; i++) {
            char c = s.charAt(i);
            long shift = totalShifts[i];

            res.append((char)(((c - 'a' + shift) % 26) + 'a'));
        }

        return res.toString();
    }
}