package leetcode.practise;

import java.util.*;
import java.util.stream.Collectors;

public class Q0347_M_TopKFrequentElements {

    private static class Node {
        private final int key;
        private int counter = 0;

        private Node(int key) {
            this.key = key;
        }

        public void incrementCount() {
            counter++;
        }

        public int getKey() {
            return key;
        }

        public int getCounter() {
            return counter;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            Node node = map.get(data);
            if (node == null) node = new Node(data);
            node.incrementCount();
            map.put(data, node);
        }
        List<Integer> data = new ArrayList<>();

        //gave run time of 14ms, beats 67.33% and memory of 47.7 MB, beats 5% - manual approach
        List<Node> nodes = new ArrayList<>(map.values());
        nodes.sort(Comparator.comparingInt(Node::getCounter));
        int j = nodes.size() - 1;
        while (k-- > 0) data.add(nodes.get(j--).getKey());
        /*
        //gave run time of 16ms, beats 34.15% and memory of 48 MB, beats 5% - streams approach
        data = map.values().stream()
                .sorted(Comparator.comparingInt(Node::getCounter).reversed())
                .limit(k)
                .map(Node::getKey)
                .collect(Collectors.toList());*/
        int[] result = new int[data.size()];
        int i = 0;
        for (Integer key : data) result[i++] = key;
        return result;
    }

    public static void main(String[] args) {
        Q0347_M_TopKFrequentElements q0347MTopKFrequentElements = new Q0347_M_TopKFrequentElements();
        Arrays.stream(q0347MTopKFrequentElements.topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3
        }, 2)).forEach(System.out::println);
    }
}
