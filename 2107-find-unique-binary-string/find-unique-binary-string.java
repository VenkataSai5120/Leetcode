class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> container = new HashSet<>();
        for (String st : nums) container.add(st);
        return findDiffString(nums[0].length(), "", container);
    }

    private String findDiffString(int len, String st, Set<String> container) {
        if (len == 0) {
            if (container.contains(st)) return "";
            return st;
        }

        String zero = findDiffString(len - 1, st + "0", container);
        if (!zero.isEmpty()) return zero;
        String one = findDiffString(len - 1, st + "1", container);
        if (!one.isEmpty()) return one;
        return "";
    }
}