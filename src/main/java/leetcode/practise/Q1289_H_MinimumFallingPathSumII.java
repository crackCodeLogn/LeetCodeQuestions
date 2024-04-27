package leetcode.practise;

import java.util.*;

public class Q1289_H_MinimumFallingPathSumII {

    public int minFallingPathSum(int[][] grid) {
        final int n = grid.length;

        for (int i = 1; i < n; ++i) {
            Pair<Integer, Integer>[] twoMinnumAndIndexes = getTwoMinnumAndIndexes(grid[i - 1]);
            final int firstMinNum = twoMinnumAndIndexes[0].getFirst();
            final int firstMinIndex = twoMinnumAndIndexes[0].getSecond();
            final int secondMinNum = twoMinnumAndIndexes[1].getFirst();
            for (int j = 0; j < n; ++j)
                if (j == firstMinIndex) grid[i][j] += secondMinNum;
                else grid[i][j] += firstMinNum;
        }

        return Arrays.stream(grid[n - 1]).min().getAsInt();
    }

    private Pair<Integer, Integer>[] getTwoMinnumAndIndexes(int[] A) {
        List<Pair<Integer, Integer>> numAndIndexes = new ArrayList<>();

        for (int i = 0; i < A.length; ++i)
            numAndIndexes.add(new Pair<>(A[i], i));

        numAndIndexes.sort(Comparator.comparingInt(Pair::getFirst));
        return new Pair[]{numAndIndexes.get(0), numAndIndexes.get(1)};
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
