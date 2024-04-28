package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-28
 */
public class Q3133_M_MinimumArrayEnd {

    public static void main(String[] args) {
        Q3133_M_MinimumArrayEnd q3133MMinimumArrayEnd = new Q3133_M_MinimumArrayEnd();
        System.out.println(q3133MMinimumArrayEnd.minEnd(3, 4)); //6
        System.out.println(q3133MMinimumArrayEnd.minEnd(2, 7)); //15
        System.out.println(q3133MMinimumArrayEnd.minEnd(3, 1)); //5
        System.out.println(q3133MMinimumArrayEnd.minEnd(3, 2)); //6
    }

    public long minEnd(int n, int x) {
        if (n == 1) return x;
        String base = Integer.toBinaryString(x);
        int c0 = 0;
        for (char ch : base.toCharArray()) if (ch == '0') c0++;

        long combinations = (long) (Math.pow(2, c0) - 1);
        if (combinations >= n - 1) {
            String val = Integer.toBinaryString(n - 1);
            StringBuilder res = new StringBuilder(base);
            int ptr = res.length() - 1;
            for (int k = val.length() - 1; k >= 0; k--) {
                char ch = val.charAt(k);
                while (res.charAt(ptr) == '1') ptr--;
                res.setCharAt(ptr--, ch);
            }
            return Long.parseLong(res.toString(), 2);
        }
        n -= combinations + 1;

        //resume work here, with the thought being to keep base as is, and then apply combinations at front, and keep manipulating the 0s seq still left
        StringBuilder res = new StringBuilder(base.replaceAll("0", "1")); // todo - incorrect this one..
        res.insert(0, Integer.toBinaryString(n));
        return Long.parseLong(res.toString(), 2);
    }
}
