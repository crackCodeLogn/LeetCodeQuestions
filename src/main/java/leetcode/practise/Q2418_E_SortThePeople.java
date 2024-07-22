package leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-07-22
 */
public class Q2418_E_SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(names[i], heights[i]));
        }
        nodes.sort(Comparator.comparingInt(Node::getHeight));
        for (int i = nodes.size() - 1, k = 0; i >= 0; i--) {
            names[k++] = nodes.get(i).name;
        }
        return names;
    }

    private final static class Node {
        String name;
        int height;

        public Node(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public String getName() {
            return name;
        }
    }
}
