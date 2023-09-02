class Solution {
    public String shortestPalindrome(String s) {
        String newSt = s + "#" +new StringBuilder(s).reverse().toString();
        int[] lps = formLPS(newSt.toCharArray());
        int longest = lps[lps.length - 1];
        return new StringBuilder(s.substring(longest)).reverse().toString() + s;
    }

    private int[] formLPS(char[] arr){
        int[] lps = new int[arr.length];
        int j = 0;

        for(int i = 1; i < arr.length;){
            if(arr[i] == arr[j]){
                lps[i] = j + 1;
                j++;
                i++;
            }
            else{
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    lps[i] =0;
                    i++;
                }
            }
        }

        return lps;
    }
}