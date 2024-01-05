class customSort implements Comparator<Integer> {
    int[] mapping;
    Map<Integer, Integer> map = new HashMap<>();

    public customSort(int[] mapping) {
        this.mapping = mapping;
    }

    public int compare(Integer a, Integer b) {
        int newA = map.getOrDefault(a, generate(a)), newB = map.getOrDefault(b, generate(b));
        map.put(a, newA);
        map.put(b, newB);
        return newA - newB;
    }

    private int generate(int a) {
        int newA = 0;
        int len = String.valueOf(a).length();

        while (len > 0) {
            newA = newA * 10 + mapping[a / (int)Math.pow(10, len - 1) % 10];
            len--;
        }

        return newA;
    }
}

class Solution {
    // public int[] sortJumbled(int[] mapping, int[] nums) {
    //     customSort cs = new customSort(mapping);
    //     Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    //     Arrays.sort(boxedNums, cs);
    //     int[] sortedNums = Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
    //     return sortedNums;
    // }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length, k = 0;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; ++i) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> convert(nums[i], mapping)));

        int[] ans = new int[n];
        for (int idx : indices)
            ans[k++] = nums[idx];
        return ans;
    }

    private int convert(int num, int[] mapping) {
        if (num == 0)
            return mapping[0];
        int n = 0, f = 1;
        
        while (num > 0) {
            n += mapping[num % 10] * f;
            f *= 10;
            num /= 10;
        }

        return n;
    }
}