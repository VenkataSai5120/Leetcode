class Solution {
  public String largestGoodInteger(String num) {
        int res = -1;

        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                res = Math.max(res, num.charAt(i) - '0');
            }
        }

        return res == -1 ? "" : String.valueOf(res).repeat(3);
    }
}