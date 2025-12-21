package leetcode.contest.weekly.w449_202505;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.Lists;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author Vivek
 * @since 2025-05-16
 */
class PaymentProcessTest {

  private PaymentProcess paymentProcess;

  @Test
  public void testCompute() {
    paymentProcess = new PaymentProcess();

    Offer offer = new Offer(12345, LocalDate.of(2021, 7, 21), 2, false, true);
    System.out.println(offer);

    Customer customer = new Customer(12345);
    List<PayCycle> payCycles =
        Lists.newArrayList(
            generatePayCycle(4, generateLocalDate(2021, 5, 7), generateLocalDate(2021, 6, 6), true),
            generatePayCycle(3, generateLocalDate(2021, 6, 7), generateLocalDate(2021, 7, 6), true),
            generatePayCycle(2, generateLocalDate(2021, 7, 7), generateLocalDate(2021, 8, 6), true),
            generatePayCycle(
                1, generateLocalDate(2021, 8, 7), generateLocalDate(2021, 9, 6), true));

    payCycles.forEach(customer::addPayCycle);
    List<Customer> customers = Lists.newArrayList(customer);

    System.out.println(customer.getPayCycles());
    paymentProcess.compute(customers, offer);

    customers.get(0).getPayCycles().forEach(System.out::println);
  }

  private LocalDate generateLocalDate(int year, int month, int day) {
    return LocalDate.of(year, month, day);
  }

  private PayCycle generatePayCycle(
      int cycleNumber, LocalDate startDate, LocalDate endDate, boolean pastDueIndicator) {
    return new PayCycle(cycleNumber, startDate, endDate, pastDueIndicator);
  }
}
