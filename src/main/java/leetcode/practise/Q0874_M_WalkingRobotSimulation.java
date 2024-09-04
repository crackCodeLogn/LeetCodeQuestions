package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-09-04
 */
public class Q0874_M_WalkingRobotSimulation {
    public static void main(String[] args) {
        Q0874_M_WalkingRobotSimulation q0874MWalkingRobotSimulation = new Q0874_M_WalkingRobotSimulation();
        System.out.println(q0874MWalkingRobotSimulation.robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
        int x = 0; // the start x
        int y = 0; // the start y
        Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();

        for (int[] o : obstacles)
            obstaclesSet.add(new Pair<>(o[0], o[1]));

        for (final int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                for (int step = 0; step < c; ++step) {
                    if (obstaclesSet.contains(new Pair<>(x + dirs[d][0], y + dirs[d][1])))
                        break;
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            ans = Math.max(ans, x * x + y * y);
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

        public static <T, K> Pair<T, K> of(T t, K k) {
            return new Pair<>(t, k);
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
