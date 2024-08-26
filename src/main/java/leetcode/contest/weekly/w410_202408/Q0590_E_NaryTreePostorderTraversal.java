package leetcode.contest.weekly.w410_202408;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-08-25
 */
public class Q0590_E_NaryTreePostorderTraversal {

    private final List<Integer> data = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        data.clear();
        postorderT(root);
        return data;
    }

    private void postorderT(Node node) { // 0ms
        if (node == null) return;
        for (int i = 0; i < node.children.size(); i++) postorderT(node.children.get(i));
        data.add(node.val);
    }

    private void postorderT2(Node node) { // 2ms
        if (node == null) return;
        node.children.forEach(this::postorderT2);
        data.add(node.val);
    }

    private static final class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
