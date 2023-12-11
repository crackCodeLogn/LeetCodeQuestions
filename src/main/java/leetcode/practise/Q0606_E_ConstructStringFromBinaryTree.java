package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-12
 */
public class Q0606_E_ConstructStringFromBinaryTree {

    private String result = "";

    public String tree2str(TreeNode root) {
        result = "";
        operate(root);
        while (result.contains("()()") || result.contains(")()")) {
            result = result.replace("()()", "")
                    .replace(")()", ")");

        }
        return result;
    }

    private void operate(TreeNode root) {
        if (root == null) {
            return;
        }
        result += root.val + "(";
        operate(root.left);
        result += ")(";
        operate(root.right);
        result += ")";
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
