package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-09
 */
public class Q1701_M_AverageWaitingTime {

    public static void main(String[] args) {
        Q1701_M_AverageWaitingTime q1701MAverageWaitingTime = new Q1701_M_AverageWaitingTime();
        System.out.println(q1701MAverageWaitingTime.averageWaitingTime(new int[][]{
                {1, 2},
                {2, 5},
                {4, 3},
        }));
        System.out.println(q1701MAverageWaitingTime.averageWaitingTime(new int[][]{
                {5, 2},
                {5, 4},
                {10, 3},
                {20, 1},
        }));
    }

    public double averageWaitingTime(int[][] customers) { // 3ms
        double sum = 0;
        customers[0][1] += customers[0][0];
        int last = customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            if (last > customers[i][0]) {
                customers[i][1] += last;
            } else {
                customers[i][1] += customers[i][0];
            }
            last = customers[i][1];
        }
        for (int i = 0; i < customers.length; i++) {
            //System.out.println(Arrays.toString(customers[i]));
            sum += customers[i][1] - customers[i][0];
        }

        return sum / customers.length;
    }
}
