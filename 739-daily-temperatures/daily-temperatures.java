class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> mono = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!mono.isEmpty() && temperatures[i] > temperatures[mono.peek()]) {
                int day = mono.pop();
                res[day] = i - day;
            }
            mono.push(i);
        }

        return res;

    }
}