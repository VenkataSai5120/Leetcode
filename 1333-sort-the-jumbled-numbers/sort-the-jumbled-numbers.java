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
    public int[] sortJumbled(int[] mapping, int[] nums) {
        customSort cs = new customSort(mapping);
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, cs);
        int[] sortedNums = Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
        return sortedNums;
    }
}