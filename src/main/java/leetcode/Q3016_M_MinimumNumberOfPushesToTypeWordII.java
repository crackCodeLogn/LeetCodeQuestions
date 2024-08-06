package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-08-06
 */
public class Q3016_M_MinimumNumberOfPushesToTypeWordII {

    public static void main(String[] args) {
        Q3016_M_MinimumNumberOfPushesToTypeWordII q3016MMinimumNumberOfPushesToTypeWordII = new Q3016_M_MinimumNumberOfPushesToTypeWordII();
        System.out.println(q3016MMinimumNumberOfPushesToTypeWordII.minimumPushes("abcde"));
        System.out.println(q3016MMinimumNumberOfPushesToTypeWordII.minimumPushes("xyzxyzxyzxyz"));
        System.out.println(q3016MMinimumNumberOfPushesToTypeWordII.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public int minimumPushes(String word) { // 20ms - need to reduce this time
        List<Node> list = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) list.add(new Node(ch));
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            list.get(ch - 'a').increment();
        }
        list.sort(Comparator.comparingInt(Node::getCount));
        int[] map = new int[26];
        for (int i = list.size() - 1, cost = 1, counter = 0; i >= 0 && list.get(i).getCount() > 0; i--) {
            if (counter == 0) cost++;
            counter = (counter + 1) % 8;
            map[list.get(i).getLetter() - 'a'] = cost - 1;
        }
        int sum = 0;
        for (int i = 0; i < word.length(); i++) sum += map[word.charAt(i) - 'a'];
        return sum;
    }

    private static final class Node {
        char letter;
        int count;

        public Node(char letter) {
            this.letter = letter;
            this.count = 0;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "letter=" + letter +
                    ", count=" + count +
                    '}';
            return sb;
        }

        public void increment() {
            count++;
        }

        public char getLetter() {
            return letter;
        }

        public int getCount() {
            return count;
        }
    }
}
