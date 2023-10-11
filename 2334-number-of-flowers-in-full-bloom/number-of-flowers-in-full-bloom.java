class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        // Arrays.sort(flowers, (a, b) -> {
        //     if (a[0] == b[0]) return b[1] - a[1];
        //     return a[0] - b[0];
        // });
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        System.out.println(Arrays.deepToString(flowers));

        for (int i = 0; i < people.length; i++) {
            int startedBlooming = findUpperBound(start, people[i]);
            int endBlooming = findLowerBound(end, people[i]);
            res[i] = startedBlooming - endBlooming;
        }

        return res;
    }

    private int findLowerBound(int[] flowers, int tar) {
        int low = 0, high = flowers.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (flowers[mid] >= tar) {
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;
    }

    private int findUpperBound(int[] flowers, int tar) {
        int low = 0, high = flowers.length - 1;
        int ret = -1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (flowers[mid] <= tar) {
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return low;
    }
}