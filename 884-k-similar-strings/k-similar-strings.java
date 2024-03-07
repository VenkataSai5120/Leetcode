class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);
        int level = 0;

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            while (qSize-- > 0) {
                String s = queue.poll();

                if (s.equals(s2)) {
                    return level;
                }

                for (String neighbour : findNeighbours(s, s2)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }

            level++;
        }

        return level;
    }

    private List<String> findNeighbours(String s1, String s2) {
        List<String> neighbours = new ArrayList<>();
        int i = 0;
        char[] arr = s1.toCharArray();

        for (; i < s1.length(); i++) {
            if (arr[i] != s2.charAt(i)) {
                break;
            }
        }

        for (int j = i + 1; j < s2.length(); j++) {
            if (s2.charAt(i) == arr[j]) {
                swap(arr, i, j);
                neighbours.add(new String(arr));
                swap(arr, i, j);
            }
        }

        return neighbours;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
