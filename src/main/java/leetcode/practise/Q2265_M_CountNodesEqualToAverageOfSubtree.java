package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-11-02
 */
public class Q2265_M_CountNodesEqualToAverageOfSubtree {

    private int cnt = 0;

    public int averageOfSubtree(TreeNode root) {
        cnt = 0;
        if (root == null) return 0;
        travel(root);
        return cnt;
    }

    private Data travel(TreeNode node) {
        if (node.left == null && node.right == null) {
            cnt++;
            return new Data(1, node.val);
        }
        Data left = null, right = null;
        if (node.left != null)
            left = travel(node.left);
        if (node.right != null)
            right = travel(node.right);

        int sum = node.val, n = 1;
        if (left != null) {
            sum += left.sum;
            n += left.n;
        }
        if (right != null) {
            sum += right.sum;
            n += right.n;
        }
        int average = sum / n;
        if (average == node.val) cnt++;
        return new Data(n, sum);
    }

    public class TreeNode {
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

    public class Data {
        public int n;
        public int sum;

        public Data(int n, int sum) {
            this.n = n;
            this.sum = sum;
        }
    }
}
