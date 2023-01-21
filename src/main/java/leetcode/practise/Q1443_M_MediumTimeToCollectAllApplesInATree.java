package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Vivek
 * @since 2023-01-11
 * <p>
 * INCOMPLETE
 */
public class Q1443_M_MediumTimeToCollectAllApplesInATree {

    private static int val = 0;

    public static void main(String[] args) {

        Q1443_M_MediumTimeToCollectAllApplesInATree q1443MMediumTimeToCollectAllApplesInATree = new Q1443_M_MediumTimeToCollectAllApplesInATree();
        System.out.println(q1443MMediumTimeToCollectAllApplesInATree.minTime(
                7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, true, true, false)
        ));
    }

    private boolean dfs(Node node, int level) {
        if (node.getChildren().isEmpty())
            return node.isApple();

        System.out.println(node.index);
        for (Node child : node.getChildren()) {
            boolean subHasApple = dfs(child, level + 1);
            if (subHasApple) val += level;
            else if (child.isApple())
                val++;
        }
        return false;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(hasApple.get(i), i);
        for (int i = 0; i < edges.length; i++) nodes[edges[i][0]].addChild(nodes[edges[i][1]]);

        dfs(nodes[0], 0);
        return -1;
    }

    private static class Node {
        private final boolean apple;
        private final int index;
        private final List<Node> children = new ArrayList<>();

        public Node(boolean apple, int index) {
            this.apple = apple;
            this.index = index;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("index=" + index)
                    .add("apple=" + apple)
                    .toString();
        }

        public boolean isApple() {
            return apple;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }
}
