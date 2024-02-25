package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-02-25
 */
public class Q2092_H_FindAllPeopleWithSecret {

    public static void main(String[] args) {
        Q2092_H_FindAllPeopleWithSecret q2092HFindAllPeopleWithSecret = new Q2092_H_FindAllPeopleWithSecret();
        System.out.println(q2092HFindAllPeopleWithSecret.findAllPeople(6, new int[][]{
                {1, 2, 5}, {2, 3, 8}, {1, 5, 10}
        }, 1));
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        TreeMap<Integer, List<Pair<Integer, Integer>>> timeToPairs = new TreeMap<>();

        uf.unionByRank(0, firstPerson);

        for (int[] m : meetings) {
            timeToPairs.putIfAbsent(m[2], new ArrayList<>());
            timeToPairs.get(m[2]).add(new Pair<>(m[0], m[1]));
        }

        for (List<Pair<Integer, Integer>> pairs : timeToPairs.values()) {
            Set<Integer> peopleUnioned = new HashSet<>();
            for (Pair<Integer, Integer> pair : pairs) {
                int x = pair.getKey();
                int y = pair.getValue();
                uf.unionByRank(x, y);
                peopleUnioned.add(x);
                peopleUnioned.add(y);
            }
            for (int person : peopleUnioned) if (!uf.connected(person, 0)) uf.reset(person);
        }
        for (int i = 0; i < n; ++i) if (uf.connected(i, 0)) ans.add(i);
        return ans;
    }

    private static class UnionFind {
        private final int[] id;
        private final int[] rank;

        public UnionFind(int n) {
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) id[i] = i;
        }

        public void unionByRank(int u, int v) {
            int i = find(u);
            int j = find(v);
            if (i == j) return;
            if (rank[i] < rank[j]) id[i] = j;
            else if (rank[i] > rank[j]) id[j] = i;
            else {
                id[i] = j;
                ++rank[j];
            }
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

        public void reset(int u) {
            id[u] = u;
        }

        private int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
