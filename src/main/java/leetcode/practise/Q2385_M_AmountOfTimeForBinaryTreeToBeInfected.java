package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-01-10
 */
public class Q2385_M_AmountOfTimeForBinaryTreeToBeInfected {

    private static final int UPPER = (int) (1e5 + 1);
    private final boolean[] visited = new boolean[UPPER];
    private final Node[] nodes = new Node[UPPER];
    private final int[] data = new int[UPPER];
    private final int[] steps = new int[UPPER];
    private final int[] steps2 = new int[UPPER];
    private final boolean[] direction = new boolean[UPPER]; //left = 0
    private int last = -1;

    public static void main(String[] args) {
        Q2385_M_AmountOfTimeForBinaryTreeToBeInfected q2385MAmountOfTimeForBinaryTreeToBeInfected = new Q2385_M_AmountOfTimeForBinaryTreeToBeInfected();
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);*/

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(q2385MAmountOfTimeForBinaryTreeToBeInfected.amountOfTime(root, 4));
    }

    public int amountOfTime(TreeNode root, int start) {
        Arrays.fill(visited, false);
        Arrays.fill(nodes, null);

        convert(null, root);
        return bfsTravel(start);
    }

    private int bfsTravel(int start) {
        Node startNode = nodes[start];
        Queue<Node> data = new LinkedList<>();
        int max = 0;
        data.offer(startNode);

        while (!data.isEmpty()) {
            List<Node> list = new ArrayList<>();
            while (!data.isEmpty()) {
                Node node = data.poll();
                visited[node.val] = true;
                for (Node link : node.getConnections())
                    if (!visited[link.val]) list.add(link);
            }
            data.addAll(list);
            list = null;
            max++;
        }
        return max;
    }

    private void convert(TreeNode parent, TreeNode node) {
        if (node == null) return;
        nodes[node.val] = new Node(node.val);
        if (parent != null) nodes[node.val].connect(nodes[parent.val]);
        convert(node, node.left);
        convert(node, node.right);
    }

    public int amountOfTime2(TreeNode root, int start) {
        Arrays.fill(data, 0);
        Arrays.fill(steps, 0);
        Arrays.fill(steps2, 0);
        Arrays.fill(direction, false); // all left
        last = -1;

        if (root.left == null && root.right == null) return 0;
        TreeNode pivot = root;
        if (root.left == null || root.right == null) {
            pivot = height(root, 0);
        }
        if (pivot == null) {
            return Math.max(steps2[last] - steps2[start], steps2[start]);
        }

        int sum = 0;

        int v1 = height(pivot.left, false, 1);
        int v2 = height(pivot.right, true, 1);
        data[pivot.val] = Math.max(v1, v2) + 1;

        if (pivot == root) {
//            int v1 = height(root.left, false, 1);
//            int v2 = height(root.right, true, 1);
//            data[root.val] = Math.max(v1, v2) + 1;

            if (root.val == start) return data[start] - 1;

            sum = Math.max(data[start] - 1, steps[start]);

            if (direction[start] && root.left != null) { //start in right
                if (data[start] - 1 < data[root.left.val])
                    sum += data[root.left.val];
                else
                    sum = Math.max(data[start] - 1, steps[start] + data[root.left.val]);
            } else if (!direction[start] && root.right != null) {
                if (data[start] - 1 < data[root.right.val])
                    sum += data[root.right.val];
                else
                    sum = Math.max(data[start] - 1, steps[start] + data[root.right.val]);
            }
        } else {
            if (root.val == start) return data[pivot.val] - 1 + steps2[pivot.val];
            if (pivot.val == start) {
                return Math.max(steps2[pivot.val], data[pivot.val] - 1);
            }
            if (steps2[start] > 0) {
                return data[pivot.val] - 1 + Math.max(steps2[pivot.val] - steps2[start], steps2[start]);
            } else {
                sum = Math.max(data[start] - 1, steps[start]);

                if (direction[start] && pivot.left != null) { //right
                    sum += Math.max(data[pivot.left.val], steps[pivot.val] - 1);
                } else if (!direction[start] && pivot.right != null) {
                    sum += Math.max(data[pivot.right.val], steps[pivot.val] - 1);
                }
            }
        }

        return sum;
    }

    private int height(TreeNode node, boolean dir, int level) {
        if (node == null) return 0;
        direction[node.val] = dir;
        steps[node.val] = level;
        if (data[node.val] > 0) return data[node.val];
        int v = Math.max(height(node.left, dir, level + 1), height(node.right, dir, level + 1)) + 1;
        data[node.val] = v;
        return v;
    }

    private TreeNode height(TreeNode node, int level) {
        if (node == null) return node;
        steps2[node.val] = level;
        if (node.left != null && node.right != null) return node;
        last = node.val;

        if (node.left != null)
            return height(node.left, level + 1);
        return height(node.right, level + 1);

    }

    private static class Node {
        private final int val;
        private final Set<Node> connections = new HashSet<>();

        private Node(int val) {
            this.val = val;
        }

        public void connect(Node other) {
            connections.add(other);
            other.connections.add(this);
        }

        public int getVal() {
            return val;
        }

        public Set<Node> getConnections() {
            return connections;
        }
    }

    private static class TreeNode {
        private final int val;
        TreeNode left;
        TreeNode right;


        private TreeNode(int val) {
            this.val = val;
        }
    }
}
