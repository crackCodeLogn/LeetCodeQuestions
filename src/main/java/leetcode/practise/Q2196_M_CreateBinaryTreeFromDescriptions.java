package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-07-15
 */
public class Q2196_M_CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> data = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode root = null;
        for (int i = 0; i < descriptions.length; i++) {
            int p = descriptions[i][0];
            int c = descriptions[i][1];
            boolean left = descriptions[i][2] == 1;

            TreeNode parent = null, child = null;
            if (data.containsKey(p)) parent = data.get(p);
            else {
                parent = gen(p);
                data.put(p, parent);
                parentMap.put(parent, null);
            }
            if (data.containsKey(c)) child = data.get(c);
            else {
                child = gen(c);
                data.put(c, child);
            }
            if (left) parent.left = child;
            else parent.right = child;

            parentMap.put(child, parent);
        }
        for (Map.Entry<TreeNode, TreeNode> entry : parentMap.entrySet()) {
            if (entry.getValue() == null) return entry.getKey();
        }
        return root;
    }

    private TreeNode gen(int v) {
        return new TreeNode(v);
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
    }
}
