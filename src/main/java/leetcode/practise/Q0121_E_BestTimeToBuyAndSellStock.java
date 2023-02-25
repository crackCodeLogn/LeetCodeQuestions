package leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-02-25
 * AC, but try to get a faster run time for this simple problem
 */
public class Q0121_E_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        Q0121_E_BestTimeToBuyAndSellStock q0121EBestTimeToBuyAndSellStock = new Q0121_E_BestTimeToBuyAndSellStock();
        System.out.println(q0121EBestTimeToBuyAndSellStock.maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
        }));
        System.out.println(q0121EBestTimeToBuyAndSellStock.maxProfit(new int[]{
                7, 6, 4, 3, 1
        }));
        System.out.println(q0121EBestTimeToBuyAndSellStock.maxProfit(new int[]{
                3, 2, 6, 5, 0, 3
        }));
    }

    public int maxProfit(int[] prices) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) list.add(new Node(prices[i], i));
        list.sort(Comparator.comparingInt(Node::getPrice));
        int diff = 0;
        for (int i = 0; i < prices.length; i++) {
            int localDiff = 0;
            for (int j = prices.length - 1; j > i; j--) {
                if (list.get(j).getIndex() > list.get(i).getIndex()) {
                    localDiff = list.get(j).getPrice() - list.get(i).getPrice();
                    break;
                }
            }
            diff = Math.max(diff, localDiff);
        }
        return diff;
    }

    private class Node {
        private final int price;
        private final int index;

        public Node(int price, int index) {
            this.price = price;
            this.index = index;
        }

        public int getPrice() {
            return price;
        }

        public int getIndex() {
            return index;
        }
    }
}