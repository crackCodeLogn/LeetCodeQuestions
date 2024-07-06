package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-06
 */
public class Q2582_E_PassThePillow {

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
