package daulspring.hellospring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {

  public static void main(String[] args) {
    List<String> scores = Arrays.asList("1","5","63","123","6","String","z","java","docker");
    Collections.sort(scores,(o1,o2) -> o1.length()-o2.length()); {}

    scores.forEach(System.out::println);
  }

}
