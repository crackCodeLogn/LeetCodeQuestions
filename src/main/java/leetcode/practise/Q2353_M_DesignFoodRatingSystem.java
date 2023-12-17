package leetcode.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2023-12-17
 */
public class Q2353_M_DesignFoodRatingSystem {

    public static void main(String[] args) {
        FoodRatings ratings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(ratings.highestRated("korean"));
        System.out.println(ratings.highestRated("japanese"));
        ratings.changeRating("sushi", 16);
        System.out.println(ratings.highestRated("japanese"));
        ratings.changeRating("ramen", 16);
        System.out.println(ratings.highestRated("japanese"));
    }

    static class FoodRatings {

        private final Map<String, PriorityQueue<Node>> cuisineMap = new HashMap<>();
        private final Map<String, Node> foodMap = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;

            for (int i = 0; i < n; i++) {
                Node node = generateNode(foods[i], cuisines[i], ratings[i]);
                foodMap.put(node.getFood(), node); //always unique
                PriorityQueue<Node> queue = cuisineMap.get(node.getCuisine());
                if (queue == null) {
                    //queue = new PriorityQueue<>(this::compareNode);
                    queue = new PriorityQueue<>();
                    cuisineMap.put(node.getCuisine(), queue);
                }
                queue.offer(node);
            }
        }

        private Node generateNode(String food, String cuisine, int rating) {
            return new Node(food, cuisine, rating);
        }

//        private int compareNode(Node n1, Node n2) {
//            int ratingDelta = n2.rating - n1.rating;
//            if (ratingDelta == 0) {
//                return n1.getFood().compareTo(n2.getFood());
//            }
//            return ratingDelta;
//        }

        public void changeRating(String food, int newRating) {
            Node node = foodMap.get(food);
            String cuisine = node.getCuisine();
            cuisineMap.get(cuisine).remove(node);
            node.setRating(newRating);
            cuisineMap.get(cuisine).offer(node);
        }

        public String highestRated(String cuisine) {
            return cuisineMap.get(cuisine).peek().getFood();
        }

        class Node implements Comparable<Node> {
            //class Node {
            private final String food;
            private final String cuisine;
            private int rating;

            public Node(String food, String cuisine) {
                this(food, cuisine, 0);
            }

            public Node(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            public String getFood() {
                return food;
            }

            public String getCuisine() {
                return cuisine;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            @Override
            public int compareTo(Node o) {
                int ratingDelta = o.rating - this.rating;
                if (ratingDelta == 0) {
                    return this.getFood().compareTo(o.getFood());
                }
                return ratingDelta;
            }
        }
    }

}
