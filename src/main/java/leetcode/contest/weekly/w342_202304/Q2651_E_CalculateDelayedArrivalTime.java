package leetcode.contest.weekly.w342_202304;

/**
 * @author Vivek
 * @since 2023-04-24
 */
public class Q2651_E_CalculateDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
