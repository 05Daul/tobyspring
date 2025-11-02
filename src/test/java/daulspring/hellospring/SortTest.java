package daulspring.hellospring;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTest {
  Sort sort;

  @BeforeEach
  void setUp() {
     sort = new Sort();
    System.out.println(this.sort);

  }

  @Test
  void sort(){

    // 준비(Given)
    // 실행(When)
    List<String> list = Arrays.asList("VZX", "XA", "DAUL");
    sort.sortByLength(list);

    // 검증(Then)
    Assertions.assertThat(list).isEqualTo(Arrays.asList("XA", "VZX", "DAUL"));

  }
  @Test
  void sortManyItems(){
    // 준비(Given)

    // 실행(When)
    List<String> list = Arrays.asList("VZX", "XA", "DAUL","length");
    sort.sortByLength(list);

    // 검증(Then)
    Assertions.assertThat(list).isEqualTo(Arrays.asList("XA", "VZX", "DAUL","length"));

  }

}
