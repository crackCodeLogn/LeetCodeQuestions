package leetcode.practise;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vivek
 * @since 2024-02-07
 */
public class Q0451_M_SortCharactersByFrequency {

    public static void main(String[] args) {
        Q0451_M_SortCharactersByFrequency q0451MSortCharactersByFrequency = new Q0451_M_SortCharactersByFrequency();
        System.out.println(q0451MSortCharactersByFrequency.frequencySort("tree")); // eert
    }

    public String frequencySort(String s) {
        Node[] data = new Node[130];
        for (int i = 0; i < data.length; i++) data[i] = new Node((char) (i));
        for (int i = 0; i < s.length(); i++) data[s.charAt(i)].bump();
        Arrays.sort(data, Comparator.comparingInt(Node::getCount));
        StringBuilder res = new StringBuilder();
        for (int i = data.length - 1; i >= 0 && data[i].getCount() > 0; i--) {
            int n = data[i].getCount();
            while (n-- > 0) res.append(data[i].getCh());
        }
        return res.toString();
    }

    private static class Node {
        final char ch;
        private int count = 0;

        public Node(char ch) {
            this.ch = ch;
        }

        public void bump() {
            count++;
        }

        public char getCh() {
            return ch;
        }

        public int getCount() {
            return count;
        }
    }
}
