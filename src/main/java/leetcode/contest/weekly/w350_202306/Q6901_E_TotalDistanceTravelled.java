package leetcode.contest.weekly.w350_202306;

/**
 * @author Vivek
 * @since 2023-06-18
 */
public class Q6901_E_TotalDistanceTravelled {

    public static void main(String[] args) {
        Q6901_E_TotalDistanceTravelled q6901ETotalDistanceTravelled = new Q6901_E_TotalDistanceTravelled();
        System.out.println(q6901ETotalDistanceTravelled.distanceTraveled(9, 2));
        System.out.println(q6901ETotalDistanceTravelled.distanceTraveled(5, 10));
        System.out.println(q6901ETotalDistanceTravelled.distanceTraveled(1, 2));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int inject = 0, dist = 0;
        while (mainTank > 0) {
            mainTank--;
            inject++;
            dist++;
            if (inject == 5) {
                inject = 0;
                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }
            }
        }
        return dist * 10;
    }
}
