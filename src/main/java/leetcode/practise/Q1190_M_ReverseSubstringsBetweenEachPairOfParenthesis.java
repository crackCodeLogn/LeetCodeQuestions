package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-07-11
 */
public class Q1190_M_ReverseSubstringsBetweenEachPairOfParenthesis {

    public static void main(String[] args) {
        Q1190_M_ReverseSubstringsBetweenEachPairOfParenthesis q1190MReverseSubstringsBetweenEachPairOfParenthesis =
                new Q1190_M_ReverseSubstringsBetweenEachPairOfParenthesis();
        System.out.println(q1190MReverseSubstringsBetweenEachPairOfParenthesis.reverseParentheses("(abcd)")); // dcba
        System.out.println(q1190MReverseSubstringsBetweenEachPairOfParenthesis.reverseParentheses("(u(love)i)")); //iloveu
        System.out.println(q1190MReverseSubstringsBetweenEachPairOfParenthesis.reverseParentheses("(ed(et(oc))el)")); // leetcode
        System.out.println(q1190MReverseSubstringsBetweenEachPairOfParenthesis.reverseParentheses("a(bcdefghijkl(mno)p)q")); // apmnolkjihgfedcbq
    }

    public String reverseParentheses(String s) { // 2ms
        Stack<Integer> stack = new Stack<>();
        StringBuilder data = new StringBuilder(s);

        for (int i = 0; i < data.length(); ) {
            if (data.charAt(i) == '(') {
                stack.push(i);
                data.deleteCharAt(i);
            } else if (data.charAt(i) == ')') {
                int startIndex = stack.pop();
                data.deleteCharAt(i);

                for (int j = startIndex, k = i - 1; j < k; ) {
                    char tmp = data.charAt(j);
                    data.setCharAt(j, data.charAt(k));
                    data.setCharAt(k, tmp);
                    j++;
                    k--;
                }
            } else {
                i++;
            }
        }
        return data.toString();
    }
}
