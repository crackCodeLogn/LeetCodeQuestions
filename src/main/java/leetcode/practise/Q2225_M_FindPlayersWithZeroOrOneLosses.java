package leetcode.practise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 2024-01-15
 */
public class Q2225_M_FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Set<Integer> blacklist = new HashSet<>();
        for (int i = 0; i < matches.length; i++) {
            int src = matches[i][0], dest = matches[i][1];
            if (!blacklist.contains(src))
                nodeMap.putIfAbsent(src, new Node());
            if (!blacklist.contains(dest))
                nodeMap.putIfAbsent(dest, new Node());

            if (!blacklist.contains(dest) && nodeMap.get(dest).addInflow(src)) {
                blacklist.add(dest);
                nodeMap.remove(dest);
            }
        }
        List<List<Integer>> data = new ArrayList<>(2);
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();

        for (Integer key : nodeMap.keySet()) {
            switch (nodeMap.get(key).getInflowSize()) {
                case 0:
                    l0.add(key);
                    break;
                case 1:
                    l1.add(key);
                    break;
            }
        }
        Collections.sort(l0);
        Collections.sort(l1);
        data.add(l0);
        data.add(l1);
        return data;
    }

    public List<List<Integer>> findWinners2(int[][] matches) {
        Map<Integer, Node2> nodeMap = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int src = matches[i][0], dest = matches[i][1];
            nodeMap.putIfAbsent(src, new Node2(src));
            nodeMap.putIfAbsent(dest, new Node2(dest));

            nodeMap.get(dest).addInflow(src);
        }
        List<List<Integer>> data = new ArrayList<>(2);
        data.add(nodeMap.keySet()
                .stream().filter(k -> nodeMap.get(k).getInflowSize() == 0)
                .sorted().collect(Collectors.toList()));
        data.add(nodeMap.keySet()
                .stream().filter(k -> nodeMap.get(k).getInflowSize() == 1)
                .sorted().collect(Collectors.toList()));
        return data;
    }

    private static class Node {
        private final Set<Integer> inflow = new HashSet<>();

        public boolean addInflow(Integer val) {
            inflow.add(val);
            return inflow.size() > 1;
        }

        public int getInflowSize() {
            return inflow.size();
        }
    }

    private static class Node2 {
        private final int val;
        private final Set<Integer> inflow = new HashSet<>();

        public Node2(int val) {
            this.val = val;
        }

        public void addInflow(Integer val) {
            inflow.add(val);
        }

        public int getInflowSize() {
            return inflow.size();
        }
    }
}
