package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-12-23
 */
public class Q1496_E_PathCrossing {

    int[][] data = new int[10001][10001];

    public boolean isPathCrossingNotAcceptedDueToLeetcodeMemoryIssue(String path) {
        int x = 0, y = 0;
        mark(0, 0);
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case 'N':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'S':
                    y++;
            }
            if (mark(x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean mark(int x, int y) {
        int m = getMark(x, y);
        x = Math.abs(x);
        y = Math.abs(y);
        if (data[x][y] == m) return true;
        data[x][y] = m;
        return false;
    }

    private int getMark(int x, int y) {
        if (x == 0 && y == 0) return -1;
        if (x > 0 && y > 0) return 1;
        if (x > 0 && y < 0) return 2;
        if (x < 0 && y < 0) return 3;
        return 4;
    }

    public boolean isPathCrossing(String path) {
        Set<String> data = new HashSet<>();
        int x = 0, y = 0;
        String coord = getData(x, y);
        data.add(coord);
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case 'N':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'S':
                    y++;
            }
            coord = getData(x, y);
            if (data.contains(coord)) {
                return true;
            }
            data.add(coord);
        }
        return false;
    }

    private String getData(int x, int y) {
        return x + " " + y;
    }
}
