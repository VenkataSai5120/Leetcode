class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        if (num <= 10 || (n.charAt(0) == '1' && num % 10 == 0 && Long.parseLong(n.substring(1)) == 0)) {
            return "" + (num - 1);
        }

        if (num == 11 || 
        (num % 10 == 1 && (n.charAt(0) == '1' && Long.parseLong(n.substring(1, len - 1)) == 0))) {
            return "" + (num - 2);
        }

        if (isAllNineDigits(n)) {
            return ""  + (num + 2);
        }
        
        boolean isEvenDigits = n.length() % 2 == 0 ? true : false;
        String palinRootStr = isEvenDigits ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        long palinRootNum= Long.parseLong(palinRootStr);

        long palinEqual = toPalindrome(palinRootStr, isEvenDigits);
        long diffEqual = Math.abs(palinEqual - num);

        long palinGreater = toPalindrome("" + (palinRootNum + 1), isEvenDigits);
        long diffGreater = Math.abs(palinGreater - num);

        long palinSmaller = toPalindrome("" + (palinRootNum - 1), isEvenDigits);
        long diffSmaller = Math.abs(palinSmaller - num);

        long closest = diffGreater < diffSmaller ? palinGreater : palinSmaller;
        long minDiff = Math.min(diffSmaller, diffGreater);

        if (diffEqual != 0) {
            if (diffEqual == minDiff) {
                closest = Math.min(closest, palinEqual);
            }
            else if (diffEqual < minDiff) {
                closest = palinEqual;
            }
        }

        return closest + "";
    }

    private boolean isAllNineDigits(String n) {
        for(char c : n.toCharArray()) {
            if (c != '9') return  false;
        }

        return true;
    }

    private long toPalindrome(String n, boolean isEvenDigits) {
        StringBuilder reversedN = new StringBuilder(n).reverse();
        String palin = isEvenDigits ? n + reversedN.toString() : n + reversedN.substring(1);
        return Long.parseLong(palin);
    }
}
