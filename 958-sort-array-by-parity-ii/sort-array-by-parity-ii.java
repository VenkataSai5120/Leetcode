
class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int i = 0, j = 1, n = arr.length;
        while (i < n && j < n) {
            while (i < n && arr[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && arr[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(arr, i, j);
            }
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}