package leetcode.practise;

import java.util.*;

public class Q0979_M_DistributeCoinInBinaryTree {
    private int moves;
    private Map<TreeNode, List<TreeNode>> graph;
    private TreeNode localSource;
    private Set<TreeNode> visited;
    private int steps;

    public static void main(String[] args) {
        Q0979_M_DistributeCoinInBinaryTree q0979MDistributeCoinInBinaryTree = new Q0979_M_DistributeCoinInBinaryTree();
        TreeNode root;
        /*root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(q0979MDistributeCoinInBinaryTree.distributeCoins(root));*/

        /*root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        System.out.println(q0979MDistributeCoinInBinaryTree.distributeCoins(root));*/

        root = new TreeNode(3);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.left.left = new TreeNode(0);
        root.right.left.left.left = new TreeNode(0);
        root.right.left.left.left.left = new TreeNode(2);
        System.out.println(q0979MDistributeCoinInBinaryTree.distributeCoins(root));
    }

    public int distributeCoins(TreeNode root) { // failed attempt
        moves = 0;
        if (root.left == null && root.right == null) return 0;

        graph = new HashMap<>();
        generateGraph(root, null);
//        System.out.println(graph);
        compute();
        return moves;
    }

    private void compute() {
        while (true) {
            TreeNode node = isAnyEmpty();
            if (node == null) return;

            localSource = null;
            visited = new HashSet<>();
            steps = Integer.MAX_VALUE;

            dfs2(node, 0);
            localSource.val--;
            node.val = 1;
            moves += steps;
        }
    }

    private void dfs2(TreeNode node, int steps) {
        if (visited.contains(node)) return;
        if (node.val > 1) {
            this.steps = Math.min(steps, this.steps);
            localSource = node;
            return;
        }
        visited.add(node);
        for (TreeNode child : graph.get(node)) dfs2(child, steps + 1);
        visited.remove(node);
    }

    private TreeNode isAnyEmpty() {
        for (TreeNode key : graph.keySet()) if (key.val == 0) return key;
        return null;
    }

    private void generateGraph(TreeNode current, TreeNode parent) {
        if (parent != null) {
            if (!graph.containsKey(parent)) graph.put(parent, new ArrayList<>());
            graph.get(parent).add(current);
            if (!graph.containsKey(current)) graph.put(current, new ArrayList<>());
            graph.get(current).add(parent);
        }
        if (current.left != null) generateGraph(current.left, current);
        if (current.right != null) generateGraph(current.right, current);
    }

    public int distributeCoins2(TreeNode root) { // 0ms
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);

        return node.val - 1 + left + right;
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
//                    "src=" + super.toString() +
                    "val=" + val +
                    '}';
        }
    }
}
