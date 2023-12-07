class Solution {
    public String largestOddNumber(String num) {
        int index = -1;

        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                index = i;
                break;
            }
        }

        return index == -1 ? "" : num.substring(0, index + 1);
    }
}