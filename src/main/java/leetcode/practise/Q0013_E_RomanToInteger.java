package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-06
 */
public class Q0013_E_RomanToInteger {

    // private static final Map<Character, Integer> map = new HashMap<>();
    private static final int[] map = new int[256];

    public static void main(String[] args) {
        Q0013_E_RomanToInteger q0013ERomanToInteger = new Q0013_E_RomanToInteger();
        System.out.println(q0013ERomanToInteger.romanToInt("III"));
        System.out.println(q0013ERomanToInteger.romanToInt("LVIII"));
        System.out.println(q0013ERomanToInteger.romanToInt("MCMXCIV"));
    }

    private void populateMap() {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        /*
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        */
    }

    public int romanToInt(String s) {
        populateMap();

        int sum = 0, i;
        for (i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i), ch2 = s.charAt(i + 1);
            //int v1 = map.get(ch1), v2 = map.get(ch2);
            int v1 = map[ch1], v2 = map[ch2];
            if (v1 < v2) {
                sum -= v1;
                sum += v2;
                i++;
            } else {
                sum += v1;
            }
        }
        //if (i == s.length() - 1) sum += map.get(s.charAt(i));
        if (i == s.length() - 1) sum += map[s.charAt(i)];

        return sum;
    }
}
