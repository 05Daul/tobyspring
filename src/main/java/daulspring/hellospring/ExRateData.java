package daulspring.hellospring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
// json에 없는 것이 들어오면 무시
public record ExRateData(String result, Map<String, BigDecimal> rates) {

}
