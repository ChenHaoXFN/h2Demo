package other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    //===============================================================================
    // 1、获取当前日期时间
    //===============================================================================
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime); // 2018-07-26T14:47:44.144

    //===============================================================================
    // 2、构造日期时间
    //===============================================================================
    CharSequence text = "2007-12-03T10:15:30";
    // 从一个文本字符串 获得 LocalDateTime实例
    LocalDateTime dateTime1 = LocalDateTime.parse(text);
    System.out.println(dateTime1); // 2007-12-03T10:15:30
    // 传入自定义文本，自定义格式化 构造 LocalDateTime 对象
    CharSequence text2 = "2012 12 12T11 11 11";
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy MM dd ");
    LocalDateTime dateTime2 = LocalDateTime.parse(text2, pattern);

    localDateTime.getDayOfMonth();
    localDateTime.getDayOfWeek();
    localDateTime.getDayOfYear();
    localDateTime.getHour();
    localDateTime.getMonth();
    localDateTime.getYear();

    System.out.println(LocalDateTime.MAX);


  }

}
