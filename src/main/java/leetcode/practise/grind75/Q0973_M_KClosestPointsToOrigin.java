package leetcode.practise.grind75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-02-02
 */
public class Q0973_M_KClosestPointsToOrigin {

    public static void main(String[] args) {
        Q0973_M_KClosestPointsToOrigin q0973MKClosestPointsToOrigin = new Q0973_M_KClosestPointsToOrigin();
        int[][] arr;
        arr = q0973MKClosestPointsToOrigin.kClosest(new int[][]{
                {1, 3}, {-2, 2}
        }, 1);
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] data = new int[k][2];
        PriorityQueue<Point> queue = new PriorityQueue<>(k);
        for (int i = 0; i < points.length; i++) {
            queue.offer(new Point(points[i][0], points[i][1]));
            if (queue.size() > k) queue.poll();
        }
        int i = 0;
        while (k-- > 0) {
            Point point = queue.poll();
            data[i][0] = point.x;
            data[i][1] = point.y;
            i++;
        }
        return data;
    }

    public int[][] kClosest2(int[][] points, int k) {
        int[][] data = new int[k][2];
        List<Point> list = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++) list.add(new Point(points[i][0], points[i][1]));
        Collections.sort(list);
        int i = 0;
        while (k-- > 0) {
            data[i][0] = list.get(i).x;
            data[i][1] = list.get(i).y;
            i++;
        }
        return data;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            //return (x - o.x) * (x + o.x) + (y - o.y) * (y + o.y);
            return (o.x - x) * (x + o.x) + (o.y - y) * (y + o.y);
        }
    }
}
