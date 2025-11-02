import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1); // -1 means uncolored

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) { // not colored
                q.add(i);
                col[i] = 0; // starting color

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int neighbor : graph[curr]) {
                        if (col[neighbor] == -1) { // not colored
                            col[neighbor] = 1 - col[curr]; // alternate color
                            q.add(neighbor);
                        } else if (col[neighbor] == col[curr]) { // same color as current
                            return false; // not bipartite
                        }
                    }
                }
            }
        }

        return true;
    }
}
