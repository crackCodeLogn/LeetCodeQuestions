package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-16
 */
public class Q0623_M_AddOneRowToTree {

    public static void main(String[] args) {
        Q0623_M_AddOneRowToTree q0623MAddOneRowToTree = new Q0623_M_AddOneRowToTree();

        TreeNode root = new TreeNode(4);
        /*root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        System.out.println(q0623MAddOneRowToTree.addOneRow(root, 1, 2).val);

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        System.out.println(q0623MAddOneRowToTree.addOneRow(root, 1, 3));*/

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(q0623MAddOneRowToTree.addOneRow(root, 5, 4));
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = generateNode(val);
            node.left = root;
            return node;
        }
        compute(root, val, depth - 1);
        return root;
    }

    private void compute(TreeNode node, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = generateNode(val);
            newNode.left = node.left;
            node.left = newNode;

            newNode = generateNode(val);
            newNode.right = node.right;
            node.right = newNode;
            return;
        }
        if (node.left != null) compute(node.left, val, depth - 1);
        if (node.right != null) compute(node.right, val, depth - 1);
    }

    private TreeNode generateNode(int val) {
        return new TreeNode(val);
    }

    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            String sb = "TreeNode{" + "val=" + val +
                    '}';
            return sb;
        }
    }
}
