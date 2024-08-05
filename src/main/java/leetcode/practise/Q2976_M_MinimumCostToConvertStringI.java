package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q2976_M_MinimumCostToConvertStringI {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost = 0;
        Graph graph = new Graph(original, changed, cost);
        for (int i = 0; i < source.length(); i++) {
            char ch1 = source.charAt(i);
            char ch2 = target.charAt(i);
            if (ch1 != ch2) {
                String s = ch1 + " " + ch2;
                Integer mc = graph.minCostMap.get(s);
                if (mc == null) return -1;
                minCost += mc;
            }
        }

        return minCost;
    }

    static class Graph {
        final Map<Character, Integer> characterIntegerMap = new HashMap<>();
        final Map<Integer, Character> integerCharacterMap = new HashMap<>();
        final Map<String, Integer> minCostMap = new HashMap<>();
        private final int V;
        private final List<List<Pair>> adj;

        Graph(char[] original, char[] changed, int[] cost) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < original.length; i++) set.add(original[i]);
            for (int i = 0; i < original.length; i++) set.add(changed[i]);
            this.V = set.size();
            adj = new ArrayList<>(V);
            int i = 0;
            for (Character ch : set) {
                characterIntegerMap.put(ch, i);
                integerCharacterMap.put(i, ch);
                adj.add(new ArrayList<>());
                i++;
            }
            for (i = 0; i < original.length; i++) addEdge(original[i], changed[i], cost[i]);
            for (Character ch : set) {
                shortestPath(ch);
            }
        }

        void addEdge(char s, char t, int w) {
            int u = characterIntegerMap.get(s);
            int v = characterIntegerMap.get(t);
            adj.get(u).add(new Pair(v, w));
            //adj.get(v).add(new Pair(u, w));
        }

        void shortestPath(char s) {
            int src = characterIntegerMap.get(s);
            PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            pq.add(new Pair(0, src));
            dist[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll().second;

                for (Pair v : adj.get(u)) {
                    if (dist[v.first] > dist[u] + v.second) {
                        dist[v.first] = dist[u] + v.second;
                        pq.add(new Pair(dist[v.first], v.first));
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    String key = s + " " + integerCharacterMap.get(i);
                    minCostMap.put(key, dist[i]);
                }
            }
        }

        static class Pair {
            int first, second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}
