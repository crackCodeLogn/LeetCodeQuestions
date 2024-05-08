package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0506_E_RelativeRanks {

    public static void main(String[] args) {
        Q0506_E_RelativeRanks q0506ERelativeRanks = new Q0506_E_RelativeRanks();
        System.out.println(Arrays.toString(q0506ERelativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(q0506ERelativeRanks.findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    public String[] findRelativeRanks(int[] score) {
        String[] data = new String[score.length];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < score.length; i++) nodes.add(new Node(i, score[i]));
        nodes.sort(Comparator.comparingInt(Node::getValue).reversed());
        for (int i = 1; i <= nodes.size(); i++) {
            Node node = nodes.get(i - 1);
            data[node.index] = String.valueOf(i);
        }
        if (data.length > 0) data[nodes.get(0).index] = "Gold Medal";
        if (data.length > 1) data[nodes.get(1).index] = "Silver Medal";
        if (data.length > 2) data[nodes.get(2).index] = "Bronze Medal";

        return data;
    }

    private static final class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
