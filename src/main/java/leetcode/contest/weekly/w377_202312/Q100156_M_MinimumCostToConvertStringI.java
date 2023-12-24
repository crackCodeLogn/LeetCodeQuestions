package leetcode.contest.weekly.w377_202312;

import java.util.*;

/**
 * @author Vivek
 * @since 2023-12-24
 * <p>
 * the 3rd question, with higher medium difficulty
 */
public class Q100156_M_MinimumCostToConvertStringI {

    public static void main(String[] args) {
        Q100156_M_MinimumCostToConvertStringI q100156MMinimumCostToConvertStringI = new Q100156_M_MinimumCostToConvertStringI();
        System.out.println(q100156MMinimumCostToConvertStringI.minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd'}, new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20}));
        System.out.println(q100156MMinimumCostToConvertStringI.minimumCost("aabbddccbc", "abbbaabaca", new char[]{'a', 'b', 'c', 'b', 'a', 'd'}, new char[]{'d', 'c', 'b', 'd', 'b', 'b'}, new int[]{3, 8, 7, 6, 7, 10}));
    }

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
                System.out.println(s + " " + mc + " " + minCost);
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
