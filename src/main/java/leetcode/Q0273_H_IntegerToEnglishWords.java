package leetcode;

/**
 * @author Vivek
 * @since 2024-08-07
 */
public class Q0273_H_IntegerToEnglishWords {

    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Q0273_H_IntegerToEnglishWords q0273HIntegerToEnglishWords = new Q0273_H_IntegerToEnglishWords();
        System.out.println(q0273HIntegerToEnglishWords.numberToWords(123));
        System.out.println(q0273HIntegerToEnglishWords.numberToWords(12345));
        System.out.println(q0273HIntegerToEnglishWords.numberToWords(1234567));
    }

    public String numberToWords(int num) {
        return num == 0 ? "Zero" : helper(num);
    }

    private String helper(int num) {
        StringBuilder s = new StringBuilder();

        if (num < 20)
            s.append(belowTwenty[num]);
        else if (num < 100)
            s.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            s.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        else if (num < 1000000)
            s.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        else if (num < 1000000000)
            s.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        else
            s.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));

        return s.toString().trim();
    }
}
