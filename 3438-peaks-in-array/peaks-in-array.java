import java.util.*;

class SegmentTree {
    long[] st;
    int n;

    public SegmentTree(int n) {
        this.n = n;
        this.st = new long[4 * n];
    }

    public void build(int index, int low, int high, long[] arr) {
        if (low == high) {
            st[index] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(2 * index + 1, low, mid, arr);
        build(2 * index + 2, mid + 1, high, arr);
        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }

    public long query(int index, int low, int high, int left, int right) {
        if (low >= left && high <= right) {
            return st[index];
        }
        if (high < left || low > right) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        long leftSum = query(2 * index + 1, low, mid, left, right);
        long rightSum = query(2 * index + 2, mid + 1, high, left, right);
        return leftSum + rightSum;
    }

    public void update(int index, int low, int high, int idx, long val) {
        if (low == high) {
            st[index] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (idx <= mid) {
            update(2 * index + 1, low, mid, idx, val);
        } else {
            update(2 * index + 2, mid + 1, high, idx, val);
        }
        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }
}

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] peak = new long[n];

        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peak[i] = 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        SegmentTree st = new SegmentTree(n);
        st.build(0, 0, n - 1, peak);

        for (int[] q : queries) {
            int type = q[0];

            if (type == 1) {
                int l = q[1];
                int r = q[2];

                if (r - l < 2) {
                    result.add(0);
                } else {
                    long res = st.query(0, 0, n - 1, l + 1, r - 1);
                    result.add((int) res);
                }
            } else if (type == 2) {
                int p = q[1];
                int x = q[2];
                nums[p] = x;

                updatePeak(p, n, nums, peak, st);
                if (p > 0) updatePeak(p - 1, n, nums, peak, st);
                if (p < n - 1) updatePeak(p + 1, n, nums, peak, st);
            }
        }

        return result;
    }

    private void updatePeak(int idx, int n, int[] nums, long[] peak, SegmentTree st) {
        if (idx > 0 && idx < n - 1) {
            if (nums[idx] > nums[idx - 1] && nums[idx] > nums[idx + 1]) {
                if (peak[idx] == 0) {
                    peak[idx] = 1;
                    st.update(0, 0, n - 1, idx, 1);
                }
            } else {
                if (peak[idx] == 1) {
                    peak[idx] = 0;
                    st.update(0, 0, n - 1, idx, 0);
                }
            }
        }
    }
}
