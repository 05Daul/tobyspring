package daulspring.hellospring;

import daulspring.hellospring.exrate.CashedExRateProvider;
import daulspring.hellospring.payment.ExRateProvider;
import daulspring.hellospring.exrate.WebApiExRateProvider;
import daulspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ObjectFactory {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(cashedexRateProvider());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new WebApiExRateProvider();
  }

  @Bean
  public ExRateProvider cashedexRateProvider() {
    return new CashedExRateProvider(exRateProvider());
  }

}
