class Solution {
    public boolean isPalindrome(int x) {
        int rev=0,x1=x;
        while(x1>0){
            int rem=x1%10;
            x1/=10;
            rev=rev*10+rem;
        }
        if (x<0) return false;

        return x == rev ? true : false;
          
    }
}