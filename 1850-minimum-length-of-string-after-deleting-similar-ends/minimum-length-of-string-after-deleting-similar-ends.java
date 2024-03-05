class Solution {
    public int minimumLength(String s) {
        int first = 0, last = s.length() - 1;
        System.out.println(s);

        while (first < last) {
            char c1 = s.charAt(first);
            char c2 = s.charAt(last);
            if (c1 != c2) break;

            while (first < last && s.charAt(first) == c1) {
                first++;
            }

            if (first == last) return 0;

            while (first < last && s.charAt(last) == c2) {
                last--;
            }

            // System.out.println(s.substring(first, last + 1));
        }

        return last - first + 1;
    }
}