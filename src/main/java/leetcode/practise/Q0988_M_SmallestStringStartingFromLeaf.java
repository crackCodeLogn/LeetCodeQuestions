package leetcode.practise;

import java.util.Arrays;

public class Q0988_M_SmallestStringStartingFromLeaf {

    private static final int LIMIT = 8500;
    private String minData;
    private char[] mData;

    public static void main(String[] args) {
        Q0988_M_SmallestStringStartingFromLeaf q0988MSmallestStringStartingFromLeaf = new Q0988_M_SmallestStringStartingFromLeaf();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(q0988MSmallestStringStartingFromLeaf.smallestFromLeaf(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(q0988MSmallestStringStartingFromLeaf.smallestFromLeaf(root));

        //TC3: [2,2,1,null,1,0,null,0]
        //TC4: [3,9,20,null,null,15,7]
        //TC5: [4,0,1,1]
    }

    public String smallestFromLeaf(TreeNode root) {
        minData = null;
        mData = new char[LIMIT];
        compute(root, LIMIT - 1);
//        compute2(root, "");
        return minData;
    }

    private void compute(TreeNode node, int ptr) { // 1ms
        mData[ptr] = getCharacter(node.val);

        if (node.left == null && node.right == null) {
            String s1 = new String(Arrays.copyOfRange(mData, ptr, LIMIT));
            if (minData == null || s1.compareTo(minData) < 0)
                minData = s1;
            return;
        }
        if (node.left != null) compute(node.left, ptr - 1);
        if (node.right != null) compute(node.right, ptr - 1);
    }

    private void compute2(TreeNode node, String builder) { // 8ms - too slow
        if (node == null) return;
        if (node.left == null && node.right == null) {
            builder = getCharacter(node.val) + builder;
            if (minData == null || builder.compareTo(minData) < 0) minData = builder;
            return;
        }
        if (node.left != null) compute2(node.left, getCharacter(node.val) + builder);
        if (node.right != null) compute2(node.right, getCharacter(node.val) + builder);
    }

    private char getCharacter(int val) {
        return (char) ('a' + val);
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
