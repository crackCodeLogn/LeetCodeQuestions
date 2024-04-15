package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-15
 */
public class Q0129_M_SumRootToLeafNumbers {
    private long sum = 0;

    public static void main(String[] args) {
        Q0129_M_SumRootToLeafNumbers q0129MSumRootToLeafNumbers = new Q0129_M_SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(q0129MSumRootToLeafNumbers.sumNumbers(root)); // 25

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(q0129MSumRootToLeafNumbers.sumNumbers(root)); // 1026
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        compute(root, 0L);
        return Math.toIntExact(sum);
    }

    private void compute(TreeNode root, long data) {
        if (root.left == null && root.right == null) {
            sum += (data * 10) + root.val;
            return;
        }
        data = (data * 10) + root.val;
        if (root.left != null) compute(root.left, data);
        if (root.right != null) compute(root.right, data);
    }

    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
