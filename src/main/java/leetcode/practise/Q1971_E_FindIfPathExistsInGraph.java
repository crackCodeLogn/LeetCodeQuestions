package leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-04-21
 */
public class Q1971_E_FindIfPathExistsInGraph {
    private static final List<Set<Integer>> data = new ArrayList<>();
    private boolean flag;

    public boolean validPath(int n, int[][] edges, int source, int destination) { // todo: learn union-find for this
        return false;
    }

    public boolean validPath2(int n, int[][] edges, int source, int destination) { // 113ms
        if (source == destination) return true;
        data.clear();
        flag = false;
        for (int i = 0; i < n; i++) data.add(new HashSet<>());

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0], dest = edges[i][1];
            data.get(src).add(dest);
            data.get(dest).add(src);
        }

        dfs(source, destination, new boolean[n]);
        return flag;
    }

    private void dfs(int src, int dest, boolean[] visited) {
        if (visited[src]) return;
        visited[src] = true;
        if (data.get(src).contains(dest)) {
            flag = true;
            return;
        }
        for (Integer node : data.get(src)) dfs(node, dest, visited);
    }

}