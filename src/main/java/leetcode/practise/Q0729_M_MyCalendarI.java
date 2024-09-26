package leetcode.practise;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2024-09-25
 */
public class Q0729_M_MyCalendarI {

  public static void main(String[] args) {
    MyCalendar myCalendar = new MyCalendar();
    //    System.out.println(myCalendar.book(10, 20));
    //    System.out.println(myCalendar.book(15, 25));
    //    System.out.println(myCalendar.book(20, 30));

    System.out.println(myCalendar.book(47, 50)); // t
    System.out.println(myCalendar.book(33, 41)); // t
    System.out.println(myCalendar.book(39, 45)); // f
    System.out.println(myCalendar.book(33, 42)); // f
    System.out.println(myCalendar.book(25, 32)); // t
    System.out.println(myCalendar.book(26, 35)); // f
    System.out.println(myCalendar.book(19, 25)); // t
    System.out.println(myCalendar.book(3, 8)); // t
    System.out.println(myCalendar.book(8, 13)); // t
    System.out.println(myCalendar.book(18, 27)); // f
    System.out.println(myCalendar.getCalendar());
  }
}

class MyCalendar {
  private final TreeSet<Pair<Integer, Integer>> calendar;

  public MyCalendar() {
    calendar = new TreeSet<>();
  }

  public boolean book(int start, int end) {
    Pair<Integer, Integer> interval = new Pair<>(start, end);

    Pair<Integer, Integer> prev = calendar.floor(interval);
    Pair<Integer, Integer> next = calendar.ceiling(interval);
    boolean b1 = false, b2 = false;
    if (prev == null && next == null) {
      calendar.add(interval);
      return true;
    } else if (prev == null) {
      if (interval.value() <= next.key()) {
        b1 = true;
      }
    } else if (next == null) {
      if (interval.key() >= prev.value()) {
        b2 = true;
      }
    } else {
      if (interval.key() >= prev.value() && interval.value() <= next.key()) {
        b1 = true;
        b2 = true;
      }
    }
    if (b1 || b2) {
      calendar.add(interval);
      return true;
    }
    return false;
  }

  public TreeSet<Pair<Integer, Integer>> getCalendar() {
    return calendar;
  }

  private record Pair<T, K>(T key, K value) implements Comparable<Pair<T, K>> {

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      Pair<T, K> other = (Pair<T, K>) obj;
      return key == other.key && value == other.value;
    }

    @Override
    public String toString() {
      return String.format("%s %s", key, value);
    }

    @Override
    public int compareTo(Pair<T, K> o) {
      return (int) key() - (int) o.key();
    }
  }
}
