package leetcode.practise;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @restarted 2023-01-02
 * INC
 * @since 23/10/22
 */
public class Q17_M_Letter_Combinations_Phone_Number {

    private final Map<Character, List<Character>> map = new HashMap<>();
    private final List<String> overall = new ArrayList<>();

    public static void main(String[] args) {
        Q17_M_Letter_Combinations_Phone_Number object = new Q17_M_Letter_Combinations_Phone_Number();
        object.init();
        System.out.println(object.map);
        System.out.println(object.letterCombinations("23"));
        System.out.println("***");
        System.out.println(object.letterCombinations("2"));
        System.out.println("***");
        System.out.println(object.letterCombinations("2985"));
        System.out.println("***");
        System.out.println(object.letterCombinations(""));
    }

    private void init() {
        overall.clear();
        map.put('2', generateList("abc"));
        map.put('3', generateList("def"));
        map.put('4', generateList("ghi"));
        map.put('5', generateList("jkl"));
        map.put('6', generateList("mno"));
        map.put('7', generateList("pqrs"));
        map.put('8', generateList("tuv"));
        map.put('9', generateList("wxyz"));
    }

    private List<Character> generateList(String chars) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length(); i++) list.add(chars.charAt(i));
        return list;
    }

    private void invoc(String digits, int index, String current) {
        if (index >= digits.length()) {
            overall.add(current);
            return;
        }
        List<Character> val = map.get(digits.charAt(index));
        for (int i = 0; i < val.size(); i++) {
            char ch = val.get(i);
            invoc(digits, index + 1, current + ch);
        }
    }

    public List<String> letterCombinations(String digits) {
        init();
        if (digits.isEmpty()) return new ArrayList<>();
        invoc(digits, 0, "");
        return overall;
    }
}