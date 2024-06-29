package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-06-29
 */
public class Q2192_M_AllAncestorsOfANodeInADirectedAcyclicGraph {

    public static void main(String[] args) {
        Q2192_M_AllAncestorsOfANodeInADirectedAcyclicGraph q2192MAllAncestorsOfANodeInADirectedAcyclicGraph = new Q2192_M_AllAncestorsOfANodeInADirectedAcyclicGraph();
        System.out.println(q2192MAllAncestorsOfANodeInADirectedAcyclicGraph.getAncestors(8, new int[][]{
                {0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}
        }));
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(new ArrayList<>(1000));

        Map<Integer, Node> map = new HashMap<>();
        for (int[] edge : edges) { // flipping direction
            int src = edge[0], dest = edge[1];
            if (!map.containsKey(src)) map.put(src, new Node(src));
            if (!map.containsKey(dest)) map.put(dest, new Node(dest));

            map.get(dest).addChild(map.get(src)); // rev connection
        }

        for (int i = 0; i < n; i++) {
            Node node = map.get(i);
            if (node == null) continue;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            dfs(node, queue, new boolean[n], node.getValue());
            while (!queue.isEmpty()) {
                result.get(i).add(queue.poll());
            }
        }

        return result;
    }

    private void dfs(Node node, PriorityQueue<Integer> result, boolean[] visited, int skip) {
        if (node == null || visited[node.getValue()]) return;

        visited[node.getValue()] = true;
        if (node.getValue() != skip) result.offer(node.getValue());
        for (Node child : node.getChildren()) dfs(child, result, visited, skip);
    }

    private static final class Node {
        private final int value;
        private final List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }


        @Override
        public String toString() {
            String sb = "Node{" + "value=" + value +
                    ", children=" + children +
                    '}';
            return sb;
        }

        public int getValue() {
            return value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }
}
