package other;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/25
 */
public class LocalDateTimeDemo {

  public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);

    CharSequence text = "2007-12-03T10:15:30";
    LocalDateTime dateTime1 = LocalDateTime.parse(text);
    System.out.println(dateTime1);

    LocalDate localDate = LocalDate.of(1, 2, 3);
    localDate = LocalDate.of(2, 3, 4);
    System.out.println(localDate);


  }

}
