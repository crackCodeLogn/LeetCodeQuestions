package leetcode.contest.weekly.w410_202408;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-08-11
 */
public class Q3249_M_CountTheNumberOfGoodNodes {

    private final Map<Integer, Node> graph = new HashMap<>();
    private int counter = 0;

    public static void main(String[] args) {
        Q3249_M_CountTheNumberOfGoodNodes q3249MCountTheNumberOfGoodNodes = new Q3249_M_CountTheNumberOfGoodNodes();
        System.out.println(q3249MCountTheNumberOfGoodNodes.countGoodNodes(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}})); // 7
        System.out.println(q3249MCountTheNumberOfGoodNodes.countGoodNodes(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}})); // 6
        System.out.println(q3249MCountTheNumberOfGoodNodes.countGoodNodes(new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}})); // 12
    }

    public int countGoodNodes(int[][] edges) {
        counter = 0;
        graph.clear();

        for (int[] edge : edges) {
            int source = edge[0], target = edge[1];
            graph.computeIfAbsent(source, k -> new Node());
            graph.computeIfAbsent(target, k -> new Node());
            graph.get(source).add(target);
            graph.get(target).add(source);
        }
        getSize(0, new HashSet<>());
        dfs(0, new HashSet<>());
        return counter;
    }

    private int getSize(int current, Set<Integer> visited) {
        if (visited.contains(current)) return 0;
        visited.add(current);

        Node node = graph.get(current);
        if (node.getNeighbors().isEmpty()) return 1;

        int sum = 0;
        for (Integer neighbor : node.getNeighbors()) sum += getSize(neighbor, visited);

        node.setSubTreeSize(sum);
        return sum + 1;
    }

    private void dfs(int current, Set<Integer> visited) {
        if (visited.contains(current)) return;

        visited.add(current);
        boolean flag = true;
        Node node = graph.get(current);
        int val = -1;
        for (Integer neighbor : node.getNeighbors())
            if (!visited.contains(neighbor)) {
                int v = graph.get(neighbor).getSubTreeSize();
                if (val == -1) val = v;
                else if (val != v) flag = false;

                dfs(neighbor, visited);
            }

        if (flag) counter++;
    }

    private static final class Node {
        private final List<Integer> neighbors;
        private int subTreeSize;

        public Node() {
            this.neighbors = new ArrayList<>();
            this.subTreeSize = 1;
        }

        public void add(int value) {
            this.neighbors.add(value);
        }

        public List<Integer> getNeighbors() {
            return neighbors;
        }

        public int getSubTreeSize() {
            return subTreeSize;
        }

        public void setSubTreeSize(int subTreeSize) {
            this.subTreeSize = subTreeSize;
        }
    }
}
