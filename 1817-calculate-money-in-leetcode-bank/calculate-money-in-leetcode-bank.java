class Solution {
    public int totalMoney(int n) {
        int nfw = n % 7, nf = n / 7;
        return 28 * nf + 7 * (nf) * (nf - 1) / 2 + nf * nfw + (nfw) * (nfw + 1) / 2;
    }
}
