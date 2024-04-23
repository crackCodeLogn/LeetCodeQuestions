package leetcode.practise;

import java.util.*;

public class Q0310_M_MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) return new ArrayList<>(List.of(0));

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) graph.put(i, new HashSet<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int label = entry.getKey();
            Set<Integer> children = entry.getValue();
            if (children.size() == 1) ans.add(label);
        }

        while (n > 2) {
            n -= ans.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leaf : ans) {
                int u = graph.get(leaf).iterator().next();
                graph.get(u).remove(leaf);
                if (graph.get(u).size() == 1) nextLeaves.add(u);
            }
            ans = nextLeaves;
        }

        return ans;
    }

    public static void main(String[] args) {
        Q0310_M_MinimumHeightTrees q0310MMinimumHeightTrees = new Q0310_M_MinimumHeightTrees();
        System.out.println(q0310MMinimumHeightTrees.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}})); // [1]
        System.out.println(q0310MMinimumHeightTrees.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}})); // [3, 4]
    }
}
