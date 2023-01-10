package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-10
 */
public class Q0100_E_SameTree {

    private static boolean result;

    public static void main(String[] args) {
        /*TreeNode np1 = new TreeNode(1);
        TreeNode np2 = new TreeNode(2);
        TreeNode np3 = new TreeNode(1);

        TreeNode nq1 = new TreeNode(1);
        TreeNode nq2 = new TreeNode(1);
        TreeNode nq3 = new TreeNode(2);

        np1.setLeft(np2);
        np1.setRight(np3);

        nq1.setLeft(nq2);
        nq1.setRight(nq3);*/
        TreeNode np1 = new TreeNode(1);
        TreeNode np3 = new TreeNode(1);

        TreeNode nq1 = new TreeNode(1);
        TreeNode nq3 = new TreeNode(1);

        np1.setRight(np3);

        nq1.setRight(nq3);

        Q0100_E_SameTree q0100ESameTree = new Q0100_E_SameTree();
        System.out.println(q0100ESameTree.isSameTree(np1, nq1));


    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        result = true;
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        travel(p, q);
        return result;
    }

    private void travel(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if (p == null || q == null) {
            result = false;
            return;
        }
        if (p.val != q.val) {
            result = false;
            return;
        }
        if (p.left == null && p.right == null && q.left == null && q.right == null) return;
        travel(p.left, q.left);
        travel(p.right, q.right);
    }

    private static class TreeNode {
        private int val;
        private TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
