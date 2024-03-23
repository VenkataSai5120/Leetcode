class Solution {
    public int maxEnvelopes(int[][] X) {
        Arrays.sort(X,(a,b) -> a[0]==b[0] ? b[1] -a[1] :a[0] -b[0]);
        int[] dp=new int[X.length];
        int ans=0;
        for(int[] env:X){
            int height =env[1];
            int left=Arrays.binarySearch(dp,0,ans,height);
            if(left<0) left=-left-1;
            if(left==ans) ans++;
            dp[left]=height;
        }
        return ans;
    }
}