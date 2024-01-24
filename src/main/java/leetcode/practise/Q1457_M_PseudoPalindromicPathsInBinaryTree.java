package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-24
 */
public class Q1457_M_PseudoPalindromicPathsInBinaryTree {

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        int[] data = new int[10];
        compute(root, data);
        return count;
    }

    private void compute(TreeNode node, int[] data) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            data[node.val]++;
            if (checkForPalindrome(data)) count++;
            data[node.val]--;
            return;
        }
        data[node.val]++;
        compute(node.left, data);
        compute(node.right, data);
        data[node.val]--;
    }

    private boolean checkForPalindrome(int[] data) {
        boolean flag = false;
        for (int i = 0; i < data.length; i++)
            if (isOdd(data[i])) {
                if (!flag) flag = true;
                else return false;
            }
        return true;
    }

    private boolean isOdd(int v) {
        return (v & 1) == 1;
    }


    private static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}
