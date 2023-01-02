package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 22/10/22
 */
public class Q12_M_Integer_To_Roman {

    private final Map<Integer, String> integerToRomanEquivalent = new HashMap<>();
    private final int[] VALUES = {1, 5, 10, 50, 100, 500, 1000};
    private final String[] SYMBOLS = {"I", "V", "X", "L", "C", "D", "M"};

    public static void main(String[] args) {
        Q12_M_Integer_To_Roman object = new Q12_M_Integer_To_Roman();
        object.mapInit();
        for (int i = 1; i <= 1001; i++)
            System.out.println(i + " " + object.intToRoman(i));
    }

    private void mapInit() {
        integerToRomanEquivalent.put(0, "");
        integerToRomanEquivalent.put(1, "I");
        integerToRomanEquivalent.put(5, "V");
        integerToRomanEquivalent.put(10, "X");
        integerToRomanEquivalent.put(50, "L");
        integerToRomanEquivalent.put(100, "C");
        integerToRomanEquivalent.put(500, "D");
        integerToRomanEquivalent.put(1000, "M");
    }

    private String intToRoman(int num) {
        if (integerToRomanEquivalent.containsKey(num)) return integerToRomanEquivalent.get(num);

        if (num > 1 && num < 4) return SYMBOLS[0] + intToRoman(num - 1);
        if (num == 4) return SYMBOLS[0] + SYMBOLS[1];
        if (num > 5 && num < 9) return SYMBOLS[1] + intToRoman(num - 5);
        if (num == 9) return SYMBOLS[0] + SYMBOLS[2];
        if (num > 10 && num < 40) return SYMBOLS[2] + intToRoman(num - 10);
        if (num >= 40 && num < 50) return SYMBOLS[2] + SYMBOLS[3] + intToRoman(num % 10);
        if (num > 50 && num < 90) return SYMBOLS[3] + intToRoman(num - 50);
        if (num >= 90 && num < 100) return SYMBOLS[2] + SYMBOLS[4] + intToRoman(num % 10);
        if (num > 100 && num < 400) return SYMBOLS[4] + intToRoman(num - 100);
        if (num >= 400 && num < 500) return SYMBOLS[4] + SYMBOLS[5] + intToRoman(num - 400);
        if (num > 500 && num < 900) return SYMBOLS[5] + intToRoman(num - 500);
        if (num >= 900 && num < 1000) return SYMBOLS[4] + SYMBOLS[6] + intToRoman(num - 900);
        return SYMBOLS[6] + intToRoman(num - 1000);
    }
}
