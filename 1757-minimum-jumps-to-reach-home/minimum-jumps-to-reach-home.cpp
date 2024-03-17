class Solution {
public:
    int bfs(std::unordered_set<int>& vis, int a, int b, int x) {
        std::queue<std::pair<int, int>> q;
        q.push({0, 1});

        int ans = 0;
        while (!q.empty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                int curr = q.front().first;
                int flag = q.front().second;
                q.pop();
                if (curr == x) return ans;
                if (vis.count(curr)) continue;

                vis.insert(curr);
                if (flag == 1 && (curr - b >= 0)) q.push({curr - b, 0});

                if ((curr - b) <= 2000) q.push({curr + a, 1});
            }
            ans++;
        }
        return -1;
    }

    int minimumJumps(std::vector<int>& forbidden, int a, int b, int x) {
        std::unordered_set<int> vis;
        for (auto& z : forbidden) vis.insert(z);

        return bfs(vis, a, b, x);
    }
};
