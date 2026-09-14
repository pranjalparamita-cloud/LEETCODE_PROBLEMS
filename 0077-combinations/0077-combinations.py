class Solution:
    def combine(self, n, k):
        ans = []

        def dfs(s, path):
            if len(path) == k:
                ans.append(path[:])  # Uses slice copy compatible with Python 2 and 3
                return

            need = k - len(path)
            for i in range(s, n - need + 2):
                path.append(i)
                dfs(i + 1, path)
                path.pop()

        dfs(1, [])
        return ans