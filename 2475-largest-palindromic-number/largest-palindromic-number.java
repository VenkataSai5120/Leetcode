class Solution {
    public String largestPalindromic(String num) {
        StringBuilder palindrome = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char midDigit = '*';

        for (char c : num.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char digit = '9'; digit >= '1'; digit--) {
            if (map.containsKey(digit)) {
                int fre = map.get(digit);
                String toBeAdded = ("" + digit).repeat(fre / 2);
                palindrome.append(toBeAdded);
                midDigit = midDigit == '*' && fre % 2 == 1 ? digit : midDigit;
            }
        }
        
        if (map.containsKey('0') && palindrome.length() > 0) {
            int fre = map.get('0');
            String toBeAdded = ("0").repeat(fre / 2);
            palindrome.append(toBeAdded);
            midDigit = midDigit == '*' && fre % 2 == 1 ? '0' : midDigit;
        }

        if (midDigit != '*') {
            palindrome.append(midDigit + "");
        }

        if (palindrome.length() > 0) {
            int len = palindrome.length() - 1;
            if (midDigit == '*') len = palindrome.length();
            String lastPart = palindrome.substring(0, len);
            palindrome.append(new StringBuilder(lastPart).reverse());
        }

        return palindrome.toString().length() == 0 ? "0" : palindrome.toString();
    }
}