package threadPoolDemo;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/19
 */
public class NewTimeDemo {

  public static void main(String args[]) {
    // 输入 20180101  获取该日期对应月份最后一天
    CharSequence str = "20040201";
    // BASIC_ISO_DATE -》ISO日期格式化，格式或解析无偏移的日期，如“20111203”。
    LocalDate localDate = LocalDate.parse(str, BASIC_ISO_DATE);
    System.out.println(LocalDateTime.now());
    // 1、 这个月月末
    System.out.println("本月月末是：" + localDate.with(TemporalAdjusters.lastDayOfMonth()));
    // 2、 下个月月初
    System.out.println("下月月初是：" + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
    // 3、 下个月月末
    System.out.println("下月月末是：" + localDate.with(TemporalAdjusters.firstDayOfNextMonth())
        .with(TemporalAdjusters.lastDayOfMonth()));
    // 4、 给年月，计算当月天数
    CharSequence str2 = "200102";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
    YearMonth ym = YearMonth.parse(str2, dateTimeFormatter);
    System.out.println(ym.lengthOfMonth());
    // 5、 日期加减天数
    System.out.println(localDate.plusDays(-1));
    System.out
        .println(YearMonth.parse(str2, DateTimeFormatter.ofPattern("yyyyMM")).lengthOfMonth());
    // 6、 日期加减月份
    System.out.println(localDate.plusMonths(-1));
    System.out.println(localDate.plusMonths(1));
    //  7、 传参月份，日子，输出修改后的
    try {
      System.out.println(localDate.withMonth(2).withDayOfMonth(30));
    } catch (DateTimeException exception) {
      System.out.println("输入日期异常！");
    }

    System.out.println(localDate.withDayOfMonth(1));
    //  8、 金毛需求
    System.out.println("--------------------");
    if (localDate.getDayOfMonth() < 15) {
      System.out.println(localDate.withDayOfMonth(15));
    } else {
      System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
    }

    Month month = localDate.getMonth();
    // 根据当前时间 获取到instant对象
    ZoneId zone = ZoneId.systemDefault();
    System.out.println("时区id----：" + zone);
    // 判断该年是否是闰年
    boolean leapYear = localDate.isLeapYear();
    System.out.println("该年是否是闰年---：" + leapYear);

    CharSequence text = "2010";
    Year year;
    System.out.println(year = Year.parse(text));
    System.out.println(year.length());
    System.out.println(LocalDate.now());
    System.out.println(LocalDateTime.now());
    System.out.println(LocalTime.now());
  }

}
