class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> win = new HashSet<>();
        Map<Integer, Integer> lose = new HashMap<>();

        for (int[] arr : matches) {
            win.add(arr[0]);
            lose.put(arr[1], lose.getOrDefault(arr[1], 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); res.add(new ArrayList<>());

        for (int n : win) {
            if (!lose.containsKey(n)) res.get(0).add(n);
        }

        for (int n : lose.keySet()) {
            if (lose.get(n) == 1) res.get(1).add(n);
        }

        Collections.sort(res.get(0)); Collections.sort(res.get(1));
        return res;
    }
}