package daulspring.hellospring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
  private Long orderId;
  private String currency;
  /// 금액과 같은 중요한 것들은 BigDecimal를 사용해야함.
  private BigDecimal foreignCurrencyAmount;
  private BigDecimal exRate;
  private BigDecimal convertedAmount;
  private LocalDateTime validUntil;

  public Payment(BigDecimal convertedAmount, String currency, BigDecimal exRate,
      BigDecimal foreignCurrencyAmount, Long orderId, LocalDateTime validUntil) {
    this.convertedAmount = convertedAmount;
    this.currency = currency;
    this.exRate = exRate;
    this.foreignCurrencyAmount = foreignCurrencyAmount;
    this.orderId = orderId;
    this.validUntil = validUntil;
  }

  public BigDecimal getConvertedAmount() {
    return convertedAmount;
  }

  public void setConvertedAmount(BigDecimal convertedAmount) {
    this.convertedAmount = convertedAmount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getExRate() {
    return exRate;
  }

  public void setExRate(BigDecimal exRate) {
    this.exRate = exRate;
  }

  public BigDecimal getForeignCurrencyAmount() {
    return foreignCurrencyAmount;
  }

  public void setForeignCurrencyAmount(BigDecimal foreignCurrencyAmount) {
    this.foreignCurrencyAmount = foreignCurrencyAmount;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public LocalDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(LocalDateTime validUntil) {
    this.validUntil = validUntil;
  }

  @Override
  public String toString() {
    return "Payment{" +
        "convertedAmount=" + convertedAmount +
        ", orderId=" + orderId +
        ", currency='" + currency + '\'' +
        ", foreignCurrencyAmount=" + foreignCurrencyAmount +
        ", exRate=" + exRate +
        ", validUntil=" + validUntil +
        '}';
  }
}
