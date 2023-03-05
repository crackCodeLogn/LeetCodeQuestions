package leetcode.contest.weekly.w335_202303;

/**
 * @author Vivek
 * @since 2023-03-05
 */
public class Q6307_Pass_the_Pillow {

    public static void main(String[] args) {
        Q6307_Pass_the_Pillow q6307PassThePillow = new Q6307_Pass_the_Pillow();
        System.out.println(q6307PassThePillow.passThePillow(2, 1));
        System.out.println(q6307PassThePillow.passThePillow(4, 5));
        System.out.println(q6307PassThePillow.passThePillow(3, 2));
        System.out.println(q6307PassThePillow.passThePillow(18, 38));
    }

    public int passThePillow(int n, int time) {
        int index = 1;
        boolean flag = true;
        while (time-- > 0) {
            if (flag) {
                index++;
            } else {
                index--;
            }
            if (index == n || index == 1) flag = !flag;
        }
        return index;
    }
}
