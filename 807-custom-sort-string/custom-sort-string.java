import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return order.indexOf(a) - order.indexOf(b);
            }
        });

        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            res.append(c);
        }
        return res.toString();
    }
}
