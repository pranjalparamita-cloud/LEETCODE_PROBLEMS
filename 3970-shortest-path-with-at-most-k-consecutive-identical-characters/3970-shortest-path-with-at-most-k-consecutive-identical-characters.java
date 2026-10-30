import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
        }

        // dist[u][cur] stores the minimum weight to reach node u with a trailing run of length cur
        int[][] dist = new int[n][k + 1];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        // Priority Queue stores triples: {distance, u, cur}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initial state: starting at node 0, initial label count is 1
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0], u = p[1], cur = p[2];

            // If we reach the destination node, return the distance
            if (u == n - 1) {
                return d;
            }

            // Skip if we've already found a better way to this state
            if (d > dist[u][cur]) {
                continue;
            }

            // Traverse outgoing edges
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                
                // Determine the next run length of consecutive identical characters
                int nxt = (labels.charAt(v) != labels.charAt(u)) ? 1 : cur + 1;
                int nd = d + w;

                // Check constraints and relaxation condition
                if (nxt <= k && nd < dist[v][nxt]) {
                    dist[v][nxt] = nd;
                    pq.offer(new int[]{nd, v, nxt});
                }
            }
        }

        // If destination node cannot be reached under the constraints
        return -1;
    }
}