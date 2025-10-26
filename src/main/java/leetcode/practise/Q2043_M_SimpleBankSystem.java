package leetcode.practise;

/**
 * @author Vivek
 * @since 10/25/25
 */
public class Q2043_M_SimpleBankSystem {
  class Bank { // 95ms, beats 97.56%
    private final long[] balance;

    public Bank(long[] balance) {
      this.balance = balance;
    }

    private boolean isValidAccount(int accId) {
      return accId >= 0 && accId < balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
      account2--;
      account1--;
      if (!isValidAccount(account1) || !isValidAccount(account2)) return false;

      if (money <= balance[account1]) {
        balance[account1] -= money;
        balance[account2] += money;
        return true;
      }
      return false;
    }

    public boolean deposit(int account, long money) {
      account--;
      if (!isValidAccount(account)) return false;

      balance[account] += money;
      return true;
    }

    public boolean withdraw(int account, long money) {
      account--;
      if (!isValidAccount(account)) return false;

      if (money <= balance[account]) {
        balance[account] -= money;
        return true;
      }
      return false;
    }
  }
}
