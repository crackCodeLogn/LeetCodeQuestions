package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-05-30
 */
public class Q1404_M_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public static void main(String[] args) {
        Q1404_M_NumberOfStepsToReduceANumberInBinaryRepresentationToOne q1404MNumberOfStepsToReduceANumberInBinaryRepresentationToOne = new Q1404_M_NumberOfStepsToReduceANumberInBinaryRepresentationToOne();
        System.out.println(q1404MNumberOfStepsToReduceANumberInBinaryRepresentationToOne.numSteps("1101")); // 6
        System.out.println(q1404MNumberOfStepsToReduceANumberInBinaryRepresentationToOne.numSteps("10")); // 1
        System.out.println(q1404MNumberOfStepsToReduceANumberInBinaryRepresentationToOne.numSteps("1")); // 0
    }

    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
            ans++;
        }

        if (sb.toString().equals("1")) return ans;
        ans++;
        for (char c : sb.toString().toCharArray()) ans += c == '1' ? 1 : 2;

        return ans;
    }
}
