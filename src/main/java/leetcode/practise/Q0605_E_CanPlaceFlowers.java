package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-19
 */
public class Q0605_E_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] data, int n) {
        if (n == 0) return true;
        if (data.length == 1) return n <= 1 && data[0] == 0;


        if (data[0] == 0 && data[1] == 0) {
            data[0] = 1;
            n--;
        }
        int i = 1;

        for (; i < data.length - 1 && n > 0; i++) {
            if (data[i] != 1 && data[i - 1] != 1 && data[i + 1] != 1) {
                data[i] = 1;
                n--;
            }
        }

        if (data[i - 1] == 0 && data[i] == 0) {
            data[i] = 1;
            n--;
        }
        return n <= 0;

    }
}
