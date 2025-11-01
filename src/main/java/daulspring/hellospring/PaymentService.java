package daulspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/// springboot를 사용치 않고, spring을 사용해보기
abstract public class PaymentService {

  public Payment prepare(String currency, BigDecimal foreignCurrencyAmount, Long orderId) {
    try {
      BigDecimal exRate = getExRate(currency);
      // 금액계산
      BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
      // 유효시간 계산
      LocalDateTime validTime = LocalDateTime.now().plusMinutes(30);

      return new Payment(convertedAmount, currency, exRate, foreignCurrencyAmount, orderId,
          validTime);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage() + " 와 같은 오류가 발생했습니다.");
    }

    return null;
  }

  abstract BigDecimal getExRate(String currency) throws IOException;
}
