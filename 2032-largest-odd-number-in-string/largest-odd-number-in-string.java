class Solution {
    public String largestOddNumber(String num) {
        int index = -1;

        for (int i = 0; i < num.length(); i++) {
            if (Character.getNumericValue(num.charAt(i)) % 2 == 1) index = i;
        }

        return index == -1 ? "" : num.substring(0, index + 1);
    }
}