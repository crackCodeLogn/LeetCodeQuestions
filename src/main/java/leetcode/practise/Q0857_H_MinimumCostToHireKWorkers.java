package leetcode.practise;

import java.util.*;

public class Q0857_H_MinimumCostToHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = Double.MAX_VALUE;
        int qualitySum = 0;
        Pair<Double, Integer>[] workers = new Pair[quality.length];
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < quality.length; ++i) workers[i] = new Pair<>((double) wage[i] / quality[i], quality[i]);

        Arrays.sort(workers, Comparator.comparingDouble(Pair::getFirst));

        for (Pair<Double, Integer> worker : workers) {
            double wagePerQuality = worker.getFirst();
            int q = worker.getSecond();
            maxHeap.offer(q);
            qualitySum += q;
            if (maxHeap.size() > k) qualitySum -= maxHeap.poll();
            if (maxHeap.size() == k) ans = Math.min(ans, qualitySum * wagePerQuality);
        }

        return ans;
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
}
