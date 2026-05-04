import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 1. Build Adjacency Lists
        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) redAdj[edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) blueAdj[edge[0]].add(edge[1]);

        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        // visited[node][color] -> color: 0 for red, 1 for blue
        boolean[][] visited = new boolean[n][2];
        
        // Queue stores: [current_node, distance, last_edge_color]
        // last_edge_color: 0 for Red, 1 for Blue
        Queue<int[]> queue = new LinkedList<>();
        
        // Start from node 0 with both colors possible next
        queue.offer(new int[]{0, 0, 0}); // Treat as if we just finished a Red edge
        queue.offer(new int[]{0, 0, 1}); // Treat as if we just finished a Blue edge
        visited[0][0] = true;
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            int lastColor = curr[2];

            // Update shortest distance to this node
            if (result[node] == -1 || dist < result[node]) {
                result[node] = dist;
            }

            // If last edge was Red (0), next must be Blue (1)
            if (lastColor == 0) {
                for (int neighbor : blueAdj[node]) {
                    if (!visited[neighbor][1]) {
                        visited[neighbor][1] = true;
                        queue.offer(new int[]{neighbor, dist + 1, 1});
                    }
                }
            } 
            // If last edge was Blue (1), next must be Red (0)
            else {
                for (int neighbor : redAdj[node]) {
                    if (!visited[neighbor][0]) {
                        visited[neighbor][0] = true;
                        queue.offer(new int[]{neighbor, dist + 1, 0});
                    }
                }
            }
        }

        return result;
    }
}
