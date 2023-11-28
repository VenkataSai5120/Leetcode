class Solution {
    public int maximumSwap(int num) {
        String n = Integer.toString(num);

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int maxIndex = i;
            boolean isChanged = false;;

            for (int j = i + 1; j < n.length(); j++) {
                if (c <= n.charAt(j)) {
                    if (c == n.charAt(j) && !isChanged) continue;
                    c = n.charAt(j);
                    maxIndex = j;
                    isChanged = true;
                }
            }

            if (maxIndex != i) {
                char[] arr = n.toCharArray();
                arr[i] = n.charAt(maxIndex);
                arr[maxIndex] = n.charAt(i);
                n = new String(arr);
                break;
            }
        }

        return Integer.parseInt(n);
    }
}