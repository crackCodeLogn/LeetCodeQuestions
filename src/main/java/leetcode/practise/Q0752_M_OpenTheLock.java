package leetcode.practise;

import java.util.*;

public class Q0752_M_OpenTheLock {
    //private Node[][] graph;
    private int[][] graph;
    private static final Map<Integer, String> numToLockMap = new HashMap<>();
    //    private static final Map<Pair<Integer, Integer>, Integer> costMap = new HashMap<>();
//    private static final Map<Pair<Integer, Integer>, Integer> subCostMap = new HashMap<>();
    private static final Map<String, Integer> costMap = new HashMap<>();
    private static final Map<String, Integer> subCostMap = new HashMap<>();
    private static final int LIMIT = 10_000;

    public int openLock(String[] deadends, String target) { // incomplete, too long
        if (numToLockMap.isEmpty()) {
            for (int i = 0; i < LIMIT; i++) numToLockMap.put(i, computeStr(i));
            for (int i = 0; i < LIMIT; i++)
                for (int j = i + 1; j < LIMIT; j++) {
                    int cost = computeCost(i, j);
//                    costMap.put(new Pair<>(i, j), cost);
//                    costMap.put(new Pair<>(j, i), cost);
                    costMap.put(getKey(i, j), cost);
                    costMap.put(getKey(j, i), cost);
                }
        }
        graph = new int[LIMIT][LIMIT];

//        for (int i = 0; i < LIMIT; i++) for (int j = 0; j < LIMIT; j++) graph[i][j] = costMap.get(new Pair<>(i, j));
        for (int i = 0; i < LIMIT; i++) for (int j = 0; j < LIMIT; j++) graph[i][j] = costMap.get(getKey(i, j));
        return -1;
    }

    private int computeCost(int i, int j) {
        String s1 = numToLockMap.get(i), s2 = numToLockMap.get(j);
        int cost = 0;
        for (int k = 0; k < 4; k++) {
            int ch1 = s1.charAt(k) - '0', ch2 = s2.charAt(k) - '0';
            if (ch1 == ch2) continue;
            //Pair<Integer, Integer> pair = new Pair<>(ch1, ch2);
            String pair = getKey(ch1, ch2);
            if (subCostMap.containsKey(pair)) cost += subCostMap.get(pair);
            else {
                if (ch1 > ch2) {
                    int t = ch1;
                    ch1 = ch2;
                    ch2 = t;
                }
                int c = (ch2 - ch1 > 5) ? ch1 + (10 - ch2) : ch2 - ch1;
                subCostMap.put(pair, c);
//                subCostMap.put(new Pair<>(ch2, ch1), c);
                subCostMap.put(getKey(ch2, ch1), c);
                cost += c;
            }
        }
        return cost;
    }

    private String computeStr(int i) {
        StringBuilder sb = new StringBuilder(i + "");
        while (sb.length() != 4) sb.insert(0, "0");
        return sb.toString();
    }

    private String getKey(int i, int j) {
        return String.format("%d %d", i, j);
    }

    private static class Pair<T, K> {
        private final T first;
        private final K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            Pair<T, K> other = (Pair<T, K>) obj;
            return first == other.first && second == other.second;
        }

        @Override
        public String toString() {
            return String.format("%s %s", first, second);
        }
    }

/*
    private static final class Node {
        private final String data;
        private final int cost;

        public Node(String data) {
            this.data = data;

        }
    }*/

    public int openLock2(String[] deadends, String target) { // 100ms
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        if (seen.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        int ans = 0;
        Queue<String> queue = new ArrayDeque<>(List.of("0000"));

        while (!queue.isEmpty()) {
            ans++;
            for (int sz = queue.size(); sz > 0; --sz) {
                StringBuilder sb = new StringBuilder(queue.poll());
                for (int i = 0; i < 4; ++i) {
                    char cache = sb.charAt(i);
                    // Increase the i-th digit by 1.
                    sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1));
                    String word = sb.toString();
                    if (word.equals(target)) return ans;
                    if (!seen.contains(word)) {
                        queue.offer(word);
                        seen.add(word);
                    }
                    sb.setCharAt(i, cache);

                    sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
                    word = sb.toString();
                    if (word.equals(target)) return ans;
                    if (!seen.contains(word)) {
                        queue.offer(word);
                        seen.add(word);
                    }
                    sb.setCharAt(i, cache);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q0752_M_OpenTheLock q0752MOpenTheLock = new Q0752_M_OpenTheLock();
        System.out.println(q0752MOpenTheLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(q0752MOpenTheLock.openLock(new String[]{"8888"}, "0009"));
        System.out.println(q0752MOpenTheLock.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }
}
