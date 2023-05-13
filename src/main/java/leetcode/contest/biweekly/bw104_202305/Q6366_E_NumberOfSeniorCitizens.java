package leetcode.contest.biweekly.bw104_202305;

/**
 * @author Vivek
 * @since 2023-05-13
 */
public class Q6366_E_NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String data : details) {
            int d = 10 * (data.charAt(11) - 48) + (data.charAt(12) - 48);
            cnt += d > 60 ? 1 : 0;
        }
        return cnt;
    }

    public int countSeniors_OriginalAC(String[] details) {
        int cnt = 0;
        for (String data : details) {
            String s = data.charAt(11) + String.valueOf(data.charAt(12));
            cnt += Integer.parseInt(s) > 60 ? 1 : 0;
        }
        return cnt;
    }
}
