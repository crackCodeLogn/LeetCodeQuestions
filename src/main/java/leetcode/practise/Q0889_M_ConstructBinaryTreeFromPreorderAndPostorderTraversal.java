package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-02-22
 */
public class Q0889_M_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

  private final Map<Integer, Integer> map = new HashMap<>();

  private static void preOrder(TreeNode node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void main(String[] args) {
    Q0889_M_ConstructBinaryTreeFromPreorderAndPostorderTraversal
        q0889MConstructBinaryTreeFromPreorderAndPostorderTraversal =
            new Q0889_M_ConstructBinaryTreeFromPreorderAndPostorderTraversal();
    TreeNode result;
    result =
        q0889MConstructBinaryTreeFromPreorderAndPostorderTraversal.constructFromPrePost(
            new int[] {1, 2, 4, 5, 3, 6, 7}, new int[] {4, 5, 2, 6, 7, 3, 1});
    preOrder(result);
    System.out.println();

    result =
        q0889MConstructBinaryTreeFromPreorderAndPostorderTraversal.constructFromPrePost(
            new int[] {1}, new int[] {1});
    preOrder(result);
  }

  public TreeNode constructFromPrePost(int[] pre, int[] post) { // 1ms, beats 53.87%
    map.clear();
    for (int i = 0; i < post.length; ++i) map.put(post[i], i);
    return build(pre, 0, pre.length - 1, 0, post.length - 1);
  }

  private TreeNode build(int[] pre, int preStart, int preEnd, int postStart, int postEnd) {
    if (preStart > preEnd) return null;
    if (preStart == preEnd) return new TreeNode(pre[preStart]);

    int rootVal = pre[preStart];
    int leftRootVal = pre[preStart + 1];
    int leftRootPostIndex = map.get(leftRootVal);
    int leftSize = leftRootPostIndex - postStart + 1;

    TreeNode root = new TreeNode(rootVal);
    root.left = build(pre, preStart + 1, preStart + leftSize, postStart, leftRootPostIndex);
    root.right = build(pre, preStart + leftSize + 1, preEnd, leftRootPostIndex + 1, postEnd - 1);
    return root;
  }

  private static final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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
