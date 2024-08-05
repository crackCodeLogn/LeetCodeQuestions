package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q2678_E_NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String code : details) {
            int age = (code.charAt(11) - '0') * 10 + (code.charAt(12) - '0');
            if (age > 60) cnt++;
        }
        return cnt;
    }
}
