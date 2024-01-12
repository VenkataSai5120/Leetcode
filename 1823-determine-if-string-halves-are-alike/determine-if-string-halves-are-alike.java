class Solution {
       public boolean halvesAreAlike(String s) {
           var vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
           int left = 0, right = 0;
           for (int i = 0, j = s.length() - 1; i < j; j--, i++) {
               left += vowels.contains(s.charAt(i)) ? 1 : 0;
               right += vowels.contains(s.charAt(j)) ? 1 : 0;
           }

           return left == right;
    }
}