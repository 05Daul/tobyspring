package daulspring.hellospring;

import java.math.BigDecimal;

public class Client {
  public static void main(String[] args) {
    PaymentService paymentService = new PaymentService();
    Payment payment = paymentService.prepare("USD", BigDecimal.valueOf(50.7), 100L);
    System.out.println(payment);
  }
}
