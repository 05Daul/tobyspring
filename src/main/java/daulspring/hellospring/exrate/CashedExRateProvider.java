package daulspring.hellospring.exrate;

import daulspring.hellospring.payment.ExRateProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashedExRateProvider implements ExRateProvider {
  private final ExRateProvider target;

  private BigDecimal cashedExRate;
  private LocalDateTime cashedExpiryTime;

  public CashedExRateProvider(ExRateProvider target) {
    this.target = target;
  }

  @Override
  public BigDecimal getExRate(String currency) throws IOException {
    if (cashedExRate == null || cashedExpiryTime.isBefore(LocalDateTime.now())) {
      cashedExRate = target.getExRate(currency);
      cashedExpiryTime = LocalDateTime.now().plusSeconds(3);
      System.out.println("cashed Updated");
    }
    return target.getExRate(currency);

  }

}
