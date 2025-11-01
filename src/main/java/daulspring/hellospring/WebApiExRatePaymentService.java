package daulspring.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExRatePaymentService extends PaymentService {
  // 환율가져오기 : https://open.er-api.com/v6/latest/USD
  @Override
  BigDecimal getExRate(String currency) throws IOException {
    URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
    /// ①InputStream : 네트워크에서 바이트 단위로 받음
    /// ②InputStreamReader : 바이트 → 문자 변환 (인코딩 기반 디코딩)
    /// ③BufferedReader : 문자 스트림 버퍼링 및 라인 단위 읽기
    String res = br.lines().collect(Collectors.joining());
    br.close();

    ObjectMapper mapper = new ObjectMapper();
    ExRateData data = mapper.readValue(res, ExRateData.class);
    BigDecimal exRate = data.rates().get("KRW");
    return exRate;
  }
}
