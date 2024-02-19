package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-19
 */
public class Q0231_E_PowerOfTwo {

    public static void main(String[] args) {
        Q0231_E_PowerOfTwo q0231EPowerOfTwo = new Q0231_E_PowerOfTwo();
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(1)); // true
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(16)); // true
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(3)); // false
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(536870912)); // true
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(2097153)); // false
        System.out.println(q0231EPowerOfTwo.isPowerOfTwo(-16)); // false
    }

    public boolean isPowerOfTwo2(long n) {
        if (n <= 0) return false;
        String val = (Math.log(n) / Math.log(2)) + "";
        val = val.substring(val.indexOf('.') + 1);
        long v = Long.parseLong(val.substring(0, Math.min(10, val.length())));
        //System.out.println(v);
        return v == 0;
    }

    public boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
