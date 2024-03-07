class NumArray {
    int[] segmentTree;
    int[] arr;
    int n;

    public NumArray(int[] arr) {
        this.n = arr.length;
        this.segmentTree = new int[4 * n];
        buildTree(0, 0, n - 1, arr);
    }

    public void buildTree(int index, int low, int high, int[] arr) {
        if (low == high) {
            segmentTree[index] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        buildTree(2 * index + 1, low, mid, arr);
        buildTree(2 * index + 2, mid + 1, high, arr);
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public int findSumInRange(int index, int low, int high, int left, int right) {
        if (low >= left && high <= right) {
            return segmentTree[index];
        }

        if (high < left || low > right) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int leftSum = findSumInRange(2 * index + 1, low, mid, left, right);
        int rightSum = findSumInRange(2 * index + 2, mid + 1, high, left, right);
        return leftSum + rightSum;
    }

    public int sumRange(int left, int right) {
        return findSumInRange(0, 0, n - 1, left, right);
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    public void update(int index, int low, int high, int idx, int val) {
        if (low == high) {
            segmentTree[index] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        if (idx <= mid) {
            update(2 * index + 1, low, mid, idx, val);
        } else {
            update(2 * index + 2, mid + 1, high, idx, val);
        }

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */