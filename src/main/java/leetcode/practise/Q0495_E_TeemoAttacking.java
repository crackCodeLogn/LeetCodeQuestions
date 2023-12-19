package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-20
 */
public class Q0495_E_TeemoAttacking {

    public int findPoisonedDuration(int[] data, int duration) {
        if (duration == 0) return 0;
        //if (duration == 1) return data.length;
        if (data.length == 1) return duration;

        int sum = 0, i = 1;
        for (; i < data.length; i++) {
            if (data[i] > data[i - 1] + duration) {
                sum += duration;
            } else {
                sum += data[i] - data[i - 1];
            }
        }
        return sum + duration;
    }
}
