class Solution {
    public String stringHash(String s, int k) {
        int index = 0;
        StringBuilder result = new StringBuilder();

        while (index < s.length()) {
            int sum = 0;
            int len = k;

            while (len-- > 0) {
                sum += (int)(s.charAt(index) - 'a');
                index++;
            }

            result.append((char)('a' + sum % 26));
        }

        return result.toString();
    }
}