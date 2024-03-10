package leetcode.contest.weekly.w386_202402;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-25
 */
public class Q3047_M_FindTheLargestAreaOfSquareInsideTwoRectangles_WA {

    public static void main(String[] args) {
        Q3047_M_FindTheLargestAreaOfSquareInsideTwoRectangles_WA q3047MFindTheLargestAreaOfSquareInsideTwoRectangles = new Q3047_M_FindTheLargestAreaOfSquareInsideTwoRectangles_WA();

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 1}, {2, 2}, {3, 1}
        }, new int[][]{
                {3, 3}, {4, 4}, {6, 6}
        })); // 1

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 1}, {2, 2}, {1, 2}
        }, new int[][]{
                {3, 3}, {4, 4}, {3, 4}
        })); // 1

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 1}, {3, 3}, {3, 1}
        }, new int[][]{
                {2, 2}, {4, 4}, {4, 2}
        })); // 0

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 3}, {4, 3}
        }, new int[][]{
                {5, 4}, {5, 5}
        })); // 1

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 2}, {1, 2}
        }, new int[][]{
                {4, 5}, {2, 3}
        })); // 1

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {1, 1}, {2, 2}, {3, 1}
        }, new int[][]{
                {3, 3}, {4, 4}, {6, 6}
        })); // 1

        System.out.println(q3047MFindTheLargestAreaOfSquareInsideTwoRectangles.largestSquareArea(new int[][]{
                {2, 3}, {1, 4}
        }, new int[][]{
                {3, 5}, {5, 5}
        })); // 1
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        List<Rectangle> rectangles = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            rectangles.add(new Rectangle(generatePoint(bottomLeft[i][0], bottomLeft[i][1]), generatePoint(topRight[i][0], topRight[i][1])));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            Rectangle rectangle1 = rectangles.get(i);
            for (int j = 0; j < n; j++) {
                Rectangle rectangle2 = rectangles.get(j);
                if (rectangle2 == rectangle1) continue;
                sum = Math.max(sum, rectangle1.overlap(rectangle2));
            }
        }
        return sum;
    }

    private Point generatePoint(int x, int y) {
        return new Point(x, y);
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static class Rectangle {
        private final Point sw;
        private final Point ne;
        private final Point nw;
        private final Point se;
        private final long length;
        private final long height;

        public Rectangle(Point sw, Point ne) {
            this.sw = sw;
            this.ne = ne;
            this.se = new Point(ne.getX(), sw.getY());
            this.nw = new Point(sw.getX(), ne.getY());
            this.length = this.ne.getX() - this.sw.getX();
            this.height = this.ne.getY() - this.sw.getY();
        }

        public long overlap(Rectangle other) {
            List<Point> overlapPoints = new ArrayList<>(4);
            Point[] arr = {nw, ne, sw, se};

            if (isPointWithin(other.getNw())) overlapPoints.add(other.getNw());
            if (isPointWithin(other.getNe())) overlapPoints.add(other.getNe());
            if (isPointWithin(other.getSw())) overlapPoints.add(other.getSw());
            if (isPointWithin(other.getSe())) overlapPoints.add(other.getSe());


            if (overlapPoints.isEmpty()) return 0;
            if (overlapPoints.size() == 4) return area(Math.min(other.getHeight(), other.getLength()));
            if (overlapPoints.size() == 2) {
                Point p1 = overlapPoints.get(0), p2 = overlapPoints.get(1);
                if (p1.getX() == p2.getX()) { //left / right
                    if (other.getSw().getX() <= this.getSw().getX()) // left
                        return area(Math.min(other.getHeight(), p1.getX() - this.sw.getX()));
                    return area(Math.min(other.getHeight(), this.se.getX() - p1.getX()));
                } else { //top / bottom
                    if (other.getNe().getY() <= this.getNe().getY()) // bottom
                        return area(Math.min(other.getLength(), p1.getY() - this.sw.getY()));
                    return area(Math.min(other.getLength(), this.nw.getY() - p1.getY()));
                }
            }
            // 1
            Point point = overlapPoints.get(0), val = null;

            double distance = Double.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                Point nearest = arr[i];
                double d = getDistance(nearest, point);
                if (d < distance) {
                    distance = d;
                    val = nearest;
                }
            }
            return area(Math.min(Math.abs(val.getX() - point.getX()), Math.abs(val.getY() - point.getY())));
        }

        private double getDistance(Point point1, Point point2) {
            return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        }

        private long area(long side) {
            return side * side;
        }

        private boolean isPointWithin(Point point) {
            int x1 = this.getSw().getX();
            int x2 = this.getNe().getX();
            int y1 = this.getSw().getY();
            int y2 = this.getNe().getY();

            int x = point.getX(), y = point.getY();
            return x >= x1 && x <= x2 && y >= y1 && y <= y2;
        }

        public long getLength() {
            return length;
        }

        public long getHeight() {
            return height;
        }

        public Point getSw() {
            return sw;
        }

        public Point getNe() {
            return ne;
        }

        public Point getNw() {
            return nw;
        }

        public Point getSe() {
            return se;
        }
    }
}
