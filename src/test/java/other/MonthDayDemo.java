package other;

import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/31
 */
public class MonthDayDemo {

  public static void main(String[] args) {
    //===============================================================================
    // 1、获取当前月日
    //===============================================================================
    MonthDay monthDay = MonthDay.now();
    System.out.println(monthDay); // --07-31

    //===============================================================================
    // 2、构造月日
    //===============================================================================
    CharSequence text1 = "--03-01";
    MonthDay monthDay1 = MonthDay.parse(text1);
    System.out.println(monthDay1); // --03-01
    CharSequence text2 = "11月23日";
    MonthDay monthDay2 = MonthDay.parse(text2, DateTimeFormatter.ofPattern("MM月dd日"));
    System.out.println(monthDay2); // --11-23
    MonthDay monthDay3 = MonthDay.of(2, 3);
    System.out.println(monthDay3); // --02-03
    MonthDay monthDay4 = MonthDay.of(Month.AUGUST, 22);
    System.out.println(monthDay4); // --08-22

    //===============================================================================
    // 3、获取 月，日
    //===============================================================================
    int monthValue = monthDay.getMonthValue();
    Month month = monthDay.getMonth();
    int dayOfMonth = monthDay.getDayOfMonth();
    System.out.println(monthValue + "月" + dayOfMonth + "日" + "月份-》" + month);
    // 7月31日月份-》JULY

    //===============================================================================
    // 4、判断大于小于，排序
    //===============================================================================
    System.out.println(monthDay.isAfter(monthDay1)); // true
    System.out.println(monthDay.isBefore(monthDay1)); // false
    System.out.println(monthDay.compareTo(monthDay1)); // 4 (这里为什么是4，上面有详解)

  }

}
