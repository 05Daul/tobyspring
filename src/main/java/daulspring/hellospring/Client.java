package daulspring.hellospring;

import static java.lang.Thread.sleep;

import daulspring.hellospring.payment.Payment;
import daulspring.hellospring.payment.PaymentService;
import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Client {

  public static void main(String[] args) throws InterruptedException {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);

    Payment payment1 = paymentService.prepare("USD", BigDecimal.valueOf(50.7), 100L);
    System.out.println(payment1);
    System.out.println("==================================");
    Payment payment2 = paymentService.prepare("USD", BigDecimal.valueOf(50.7), 100L);
    System.out.println(payment2);
    System.out.println("==================================");
    sleep(5000);
    Payment payment3 = paymentService.prepare("USD", BigDecimal.valueOf(50.7), 100L);
    System.out.println(payment3);
  }
}
