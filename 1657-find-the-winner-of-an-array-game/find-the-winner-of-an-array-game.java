class Solution {
    public int getWinner(int[] arr, int k) {
        // boolean goAhead = true;
        // int index = 1;
        // int n = arr.length;

        // if (k >= n) {
        //     int max = -1;
        //     for (int ele : arr) max = Math.max(max, ele);
        //     return max;
        // }

        // while (goAhead) {
        //     int countK = 1;
            
        //     if (arr[0] < arr[index]) {
        //         arr[0] = arr[0] ^ arr[index] ^ (arr[index] = arr[0]);
        //     }

        //     index = (index + 1) % n;
        //     if (index == 0) index++;

        //     while (arr[0] > arr[index] && countK != k) {
        //         countK++;
        //         index = (index + 1) % n;
        //         if (index == 0) index++;
        //     }

        //     if (countK == k) return arr[0];
        // }

        // return -1;

        int curr = arr[0], win = 0;

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > curr) {
                curr = arr[i];
                win = 0;
            }
            if (++win == k) break;
        }
        
        return curr;
    }
}