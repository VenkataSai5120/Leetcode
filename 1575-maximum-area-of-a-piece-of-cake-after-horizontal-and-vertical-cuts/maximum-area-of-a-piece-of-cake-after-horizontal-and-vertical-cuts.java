class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);

        int maxHor = findMaxGap(hc, h);
        int maxVer = findMaxGap(vc, w);

        return (int)(((long)maxVer * maxHor) % 1_000_000_007);
    }

    private int findMaxGap(int[] cuts, int len) {
        int maxGap = 0;
        int start = 0;

        for (int cut : cuts) {
            maxGap = Math.max(maxGap, cut - start);
            start = cut;
        }

        maxGap = Math.max(len - start, maxGap);
        return maxGap;
    }
}