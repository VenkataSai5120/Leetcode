class Solution {

	private int[] createMax(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[k];
		Stack<Integer> stack = new Stack<>();
		int removePossible = n - k;

		for (int ele : nums) {
			while (!stack.isEmpty() && removePossible > 0 && stack.peek() < ele) {
				stack.pop();
				removePossible--;
			}

			stack.push(ele);
		}

		while (stack.size() > k) stack.pop();

		for (int i = k - 1; !stack.isEmpty(); i--) {
			res[i] = stack.pop();
		}

		return res;
	}

	private boolean findWhichOne(int[] arr1, int[] arr2, int index1, int index2) {
		while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) return false;
            else if (arr1[index1] > arr2[index2]) return true;
            else {
                index1++;
                index2++;
            }
        }

        return index1 != arr1.length;
	}

	private int[] merge(int[] arr1, int[] arr2, int k) {
		int[] res = new int[k];
		int index1 = 0, index2 = 0;
		int index = 0;

		while (index < k) {
			res[index++] = findWhichOne(arr1, arr2, index1, index2) ? 
			arr1[index1++] : arr2[index2++];
		}

		return res;
	} 

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		int n1 = nums1.length;
		int n2 = nums2.length;

		for (int i = 0; i <= k; i++) {
			int len1 = i;
			int len2 = k - i;

			if (len1 <= n1 && len2 <= n2) {
				int[] maxArr1 = createMax(nums1, len1);
				int[] maxArr2 = createMax(nums2, len2);
				int[] currRes = merge(maxArr1, maxArr2, k);

				if (!findWhichOne(res, currRes, 0, 0)) {
					res = currRes;
				}
			}
		}   

		return res;
	}
}