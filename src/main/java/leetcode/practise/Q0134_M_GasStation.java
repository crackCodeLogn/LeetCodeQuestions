package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-07
 */
public class Q0134_M_GasStation {

   /* public int canCompleteCircuit(int[] gas, int[] cost) {
        long sum = 0;
        for (int i = 0; i < gas.length; i++)
            sum += gas[i] - cost[i];
        if (sum < 0) return -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0) {
                int jSum = gas[i] - cost[i];
                int j = (i + 1) % gas.length;
                for (; j != i; j = (j + 1) % gas.length) {
                    if (jSum + gas[j] - cost[j] < 0) {
                        break;
                    }
                    jSum += gas[j] - cost[j];
                }
                if (j == i) return i;
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        Q0134_M_GasStation q0134MGasStation = new Q0134_M_GasStation();
        /*System.out.println(q0134MGasStation.canCompleteCircuit(new int[]{
                1, 2, 3, 4, 5
        }, new int[]{
                3, 4, 5, 1, 2
        }));

        System.out.println(q0134MGasStation.canCompleteCircuit(new int[]{
                2, 3, 4
        }, new int[]{
                3, 4, 3
        }));*/

        System.out.println(q0134MGasStation.canCompleteCircuit(new int[]{
                5, 8, 2, 8
        }, new int[]{
                6, 5, 6, 6
        }));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sum = 0;
        for (int i = 0; i < gas.length; i++)
            sum += gas[i] - cost[i];
        if (sum < 0) return -1;
        int index = 0, run = 0;
        for (int i = 0; i < gas.length; i++) {
            run += gas[i] - cost[i];
            if (run < 0) {
                run = 0;
                index = i + 1;
            }
        }
        return index;
    }
}