class Pair {
    int ele;
    int ind;

    Pair(int ele, int ind) {
        this.ele = ele;
        this.ind = ind;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nums[i], i));
        }

        pairs.sort(Comparator.comparingInt(a -> a.ele));
        List<List<Pair>> groupedEle = new ArrayList<>();
        groupedEle.add(new ArrayList<Pair>(Arrays.asList(pairs.get(0))));

        for (int i = 1; i < n; i++) {
            if (pairs.get(i).ele - pairs.get(i - 1).ele <= limit) {
                groupedEle.get(groupedEle.size() - 1).add(pairs.get(i));
            }
            else {
                groupedEle.add(new ArrayList<>(Arrays.asList(pairs.get(i))));
            }
        }

        for (List<Pair> l : groupedEle) {
            List<Pair> sortInd = new ArrayList<>(l);
            sortInd.sort(Comparator.comparingInt(a -> a.ind));

            for (int i = 0; i < l.size(); i++) {
                nums[sortInd.get(i).ind] = l.get(i).ele;
            }
        }

        return nums;
    }
}