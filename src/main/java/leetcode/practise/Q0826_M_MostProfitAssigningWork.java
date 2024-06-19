package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0826_M_MostProfitAssigningWork {

    public static void main(String[] args) {
        Q0826_M_MostProfitAssigningWork q0826MMostProfitAssigningWork = new Q0826_M_MostProfitAssigningWork();
        System.out.println(q0826MMostProfitAssigningWork.maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7})); // 100
        System.out.println(q0826MMostProfitAssigningWork.maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25})); // 0
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < difficulty.length; ++i)
            jobs.add(new Pair<>(difficulty[i], profit[i]));

        jobs.sort(Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);

        int i = 0;
        int maxProfit = 0;

        for (final int w : worker) {
            for (; i < jobs.size() && w >= jobs.get(i).getKey(); ++i)
                maxProfit = Math.max(maxProfit, jobs.get(i).getValue());
            ans += maxProfit;
        }

        return ans;
    }

    private static final class Pair<T, K> {
        private final T key;
        private final K value;

        public Pair(T key, K value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public K getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            Pair<T, K> other = (Pair<T, K>) obj;
            return key == other.key && value == other.value;
        }

        @Override
        public String toString() {
            return String.format("%s %s", key, value);
        }
    }
}
