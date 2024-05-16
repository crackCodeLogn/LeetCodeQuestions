package leetcode.practise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Q2812_M_FindTheSafestPathInAGrid {
    private static final int[] X_4W = {0, 1, 0, -1};
    private static final int[] Y_4W = {1, 0, -1, 0};
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] distance;
    private int n;
    private int maxSafe;
    private boolean[][] visited;

    // expects input to be in format "[[1,0,0],[0,0,0],[0,0,1]]"
    private static List<List<Integer>> converter(String data) {
        List<List<Integer>> result = new ArrayList<>();
        data = data.substring(1, data.length() - 1);
        Pattern pattern = Pattern.compile("\\[(.*?)]");
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String str = matcher.group(0);
            str = str.substring(1, str.length() - 1);

            List<Integer> list = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Q2812_M_FindTheSafestPathInAGrid q2812MFindTheSafestPathInAGrid = new Q2812_M_FindTheSafestPathInAGrid();
        System.out.println(q2812MFindTheSafestPathInAGrid.maximumSafenessFactor(converter("[[1,0,0],[0,0,0],[0,0,1]]"))); // 0
        System.out.println(q2812MFindTheSafestPathInAGrid.maximumSafenessFactor(converter("[[0,0,1],[0,0,0],[0,0,0]]"))); // 2
        System.out.println(q2812MFindTheSafestPathInAGrid.maximumSafenessFactor(converter("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]"))); // 2
        System.out.println(q2812MFindTheSafestPathInAGrid.maximumSafenessFactor(converter("[[0,0,1],[0,0,1],[0,0,0]]"))); // 1
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = getDistToThief(grid);
        int l = 0;
        int r = grid.size() * 2;

        while (l < r) {
            final int m = (l + r) / 2;
            if (hasValidPath(distToThief, m)) l = m + 1;
            else r = m;
        }
        return l - 1;
    }

    private boolean hasValidPath(int[][] distToThief, int safeness) {
        if (distToThief[0][0] < safeness)
            return false;

        final int n = distToThief.length;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>(List.of(new Pair<>(0, 0)));
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        while (!q.isEmpty()) {
            final int i = q.peek().getKey();
            final int j = q.poll().getValue();
            if (distToThief[i][j] < safeness)
                continue;
            if (i == n - 1 && j == n - 1)
                return true;
            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];
                if (x < 0 || x == n || y < 0 || y == n)
                    continue;
                if (seen[x][y])
                    continue;
                q.offer(new Pair<>(x, y));
                seen[x][y] = true;
            }
        }

        return false;
    }

    private int[][] getDistToThief(List<List<Integer>> grid) {
        final int n = grid.size();
        int[][] distToThief = new int[n][n];
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid.get(i).get(j) == 1) {
                    q.offer(new Pair<>(i, j));
                    seen[i][j] = true;
                }

        for (int dist = 0; !q.isEmpty(); ++dist) {
            for (int sz = q.size(); sz > 0; --sz) {
                final int i = q.peek().getKey();
                final int j = q.poll().getValue();
                distToThief[i][j] = dist;
                for (int[] dir : dirs) {
                    final int x = i + dir[0];
                    final int y = j + dir[1];
                    if (x < 0 || x == n || y < 0 || y == n)
                        continue;
                    if (seen[x][y])
                        continue;
                    q.offer(new Pair<>(x, y));
                    seen[x][y] = true;
                }
            }
        }

        return distToThief;
    }

    public int maximumSafenessFactor2(List<List<Integer>> grid) { // my attempted - goes TLE for 989th out of 1036 TC
        n = grid.size();
        distance = new int[n][n];
        maxSafe = -1;

        Queue<int[]> thieves = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                if (grid.get(i).get(j) == 1) thieves.add(generatePair(i, j));
            }
        while (!thieves.isEmpty()) {
            int[] pair = thieves.poll();
            mark(pair[0], pair[1]);
        }
        if (distance[0][0] == 0 || distance[n - 1][n - 1] == 0) return 0;
        int lower = 0, upper = maxSafe;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            int v = path(mid);
            if (v > 0) lower = mid + 1;
            else upper = mid;
        }
        return Math.max(lower - 1, 0);
    }

    private int path(int level) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(generatePair(0, 0));
        visited = new boolean[n][n];
        int min = level;

        while (!queue.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];

                if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || distance[i][j] < min) continue;
                visited[i][j] = true;
                min = Math.min(min, distance[i][j]);
                if (i == n - 1 && j == n - 1) return min;
//                System.out.println(i + " " + j);

                for (int k = 0; k < X_4W.length; k++) list.add(generatePair(i + X_4W[k], j + Y_4W[k]));
            }
            queue.addAll(list);
        }
        return 0;
    }

    private void mark(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(generatePair(x, y));
        int level = 0;
        visited = new boolean[n][n];

        while (!queue.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) continue;
                visited[i][j] = true;
                distance[i][j] = Math.min(distance[i][j], level);
                maxSafe = Math.max(maxSafe, distance[i][j]);
                for (int k = 0; k < X_4W.length; k++) list.add(generatePair(i + X_4W[k], j + Y_4W[k]));
            }
            queue.addAll(list);
            level++;
        }
    }

    private int[] generatePair(int a, int b) {
        return new int[]{a, b};
    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static final class Pair<T, K> {
        private final T key;
        private final K value;

        public Pair(T key, K second) {
            this.key = key;
            this.value = second;
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
