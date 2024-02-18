package leetcode.contest.weekly.w385_202402;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-02-18
 */
public class Q100229_M_FindTheLengthOfTheLongestCommonPrefix {

    public static void main(String[] args) {
        Q100229_M_FindTheLengthOfTheLongestCommonPrefix q100229MFindTheLengthOfTheLongestCommonPrefix = new Q100229_M_FindTheLengthOfTheLongestCommonPrefix();
        System.out.println(q100229MFindTheLengthOfTheLongestCommonPrefix.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000})); // 3
        System.out.println(q100229MFindTheLengthOfTheLongestCommonPrefix.longestCommonPrefix(new int[]{1, 10, 100, 1050, 120}, new int[]{1000})); // 3
        System.out.println(q100229MFindTheLengthOfTheLongestCommonPrefix.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{4, 4, 4})); // 0
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();
        for (int i = 0; i < arr1.length; i++) populateTree(root, String.valueOf(arr1[i]));

        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            cnt = Math.max(cnt, trace(root, String.valueOf(arr2[i])));
        }
        return cnt;
    }

    private int trace(Node node, String value) {
        for (int i = 0; i < value.length(); i++) {
            int v = value.charAt(i) - '0';
            node = node.contains(v);
            if (node == null) return i;
        }
        return value.length();
    }

    private void populateTree(Node node, String value) {
        for (int i = 0; i < value.length(); i++) {
            int v = value.charAt(i) - '0';
            node = node.addChild(v);
        }
    }

    private static class Node {
        //private final Node[] children = new Node[9];
        private final Map<Integer, Node> children = new HashMap<>(9);

        public Node addChild(int k) {
            Node node = new Node();
            if (!children.containsKey(k)) children.put(k, node);
            else node = children.get(k);
            return node;
        }

        public Node contains(int k) {
            return children.get(k);
        }
    }
}
