package daulspring.hellospring;

import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);

    Payment payment = paymentService.prepare("USD", BigDecimal.valueOf(50.7), 100L);
    System.out.println(payment);
  }
}
