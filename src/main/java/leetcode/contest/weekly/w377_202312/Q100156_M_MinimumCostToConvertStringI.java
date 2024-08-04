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
        System.out.println(q100156MMinimumCostToConvertStringI.minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd'}, new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20})); //28
        System.out.println(q100156MMinimumCostToConvertStringI.minimumCost("aabbddccbc", "abbbaabaca", new char[]{'a', 'b', 'c', 'b', 'a', 'd'}, new char[]{'d', 'c', 'b', 'd', 'b', 'b'}, new int[]{3, 8, 7, 6, 7, 10})); //-1
    }

    private static Pair<Integer, Integer> generatePair(int x, int y) {
        return new Pair<>(x, y);
    }

    private static Pair<Character, Character> generatePair(char x, char y) {
        return new Pair<>(x, y);
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost = 0;
        Graph graph = new Graph(original, changed, cost);
        for (int i = 0; i < source.length(); i++) {
            char ch1 = source.charAt(i);
            char ch2 = target.charAt(i);
            if (ch1 != ch2) {
                //String s = ch1 + " " + ch2;
                Integer mc = graph.minCostMap.get(generatePair(ch1, ch2));
                if (mc == null) return -1;
                minCost += mc;
                System.out.println(generatePair(ch1, ch2) + " " + mc + " " + minCost);
            }
        }

        return minCost;
    }

    static class Graph {
        final Map<Character, Integer> characterIntegerMap = new HashMap<>();
        final Map<Integer, Character> integerCharacterMap = new HashMap<>();
        final Map<Pair<Character, Character>, Integer> minCostMap = new HashMap<>();
        private final int V;
        private final List<List<Pair<Integer, Integer>>> adj;

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
            for (Character ch : set) shortestPath(ch);
        }

        void addEdge(char s, char t, int w) {
            int u = characterIntegerMap.get(s);
            int v = characterIntegerMap.get(t);
            adj.get(u).add(generatePair(v, w));
            //adj.get(v).add(new Pair(u, w));
        }

        void shortestPath(char s) {
            int src = characterIntegerMap.get(s);
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(V, Comparator.comparingInt(Pair::getFirst));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            pq.add(generatePair(0, src));
            dist[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll().getSecond();

                for (Pair<Integer, Integer> v : adj.get(u)) {
                    if (dist[v.getFirst()] > dist[u] + v.getSecond()) {
                        dist[v.getFirst()] = dist[u] + v.getSecond();
                        pq.add(generatePair(dist[v.getFirst()], v.getFirst()));
                    }
                }
            }

            for (int i = 0; i < V; i++)
                if (dist[i] != Integer.MAX_VALUE) minCostMap.put(generatePair(s, integerCharacterMap.get(i)), dist[i]);
        }
    }

    static class Pair<T, K> {
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
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return String.format("%s %s", first, second);
        }
    }


}
