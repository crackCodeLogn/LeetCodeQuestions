package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-09-02
 */
public class Q1945_E_SumOfDigitsOfStringAfterConvert {

    public static void main(String[] args) {
        Q1945_E_SumOfDigitsOfStringAfterConvert q1945ESumOfDigitsOfStringAfterConvert = new Q1945_E_SumOfDigitsOfStringAfterConvert();
        System.out.println(q1945ESumOfDigitsOfStringAfterConvert.getLucky("iiii", 1)); // 36
        System.out.println(q1945ESumOfDigitsOfStringAfterConvert.getLucky("leetcode", 2)); // 6
        System.out.println(q1945ESumOfDigitsOfStringAfterConvert.getLucky("zbax", 2)); // 8
    }

    public int getLucky(String s, int k) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) num += getNum(s.charAt(i) - 'a' + 1);
        k--;
        while (k-- > 0) num = getNum(num);
        return num;
    }

    private int getNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
