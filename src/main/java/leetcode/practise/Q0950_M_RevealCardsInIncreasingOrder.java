package leetcode.practise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Vivek
 * @since 2024-04-10
 */
public class Q0950_M_RevealCardsInIncreasingOrder {

    public static void main(String[] args) {
        Q0950_M_RevealCardsInIncreasingOrder q0950MRevealCardsInIncreasingOrder = new Q0950_M_RevealCardsInIncreasingOrder();
        System.out.println(Arrays.toString(q0950MRevealCardsInIncreasingOrder.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}))); // 2,13,3,11,5,17,7
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int i = deck.length - 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(deck[i--]);

        while (i >= 0) {
            deque.addFirst(deque.getLast());
            deque.pollLast();
            deque.addFirst(deck[i--]);
        }
        i = 0;
        while (!deque.isEmpty()) deck[i++] = deque.pollFirst();
        return deck;
    }
}
