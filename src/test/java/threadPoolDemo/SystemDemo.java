package threadPoolDemo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">陈浩</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/24
 */
public class SystemDemo {

  private static OperatingSystemMXBean _systemMXBean;

  public static void main(String[] args) {

    _systemMXBean = ManagementFactory.getOperatingSystemMXBean();
    // 系统名称
    System.out.println("目前操作系统名称：" + _systemMXBean.getName());
    // 操作系统版本
    System.out.println("目前操作系统版本：" + _systemMXBean.getVersion());
    // 操作系统位数
    System.out.println("目前操作系统位数：" + _systemMXBean.getArch());
    System.out.println("目前cpu处理器个数：" + Runtime.getRuntime().availableProcessors());
    System.out.println("目前cpu处理器个数：" + _systemMXBean.getAvailableProcessors());
    System.out.println(_systemMXBean.getSystemLoadAverage());
    System.out.println("java版本号：" + System.getProperty("java.version"));

    System.out.println("最大内存：" + Runtime.getRuntime().totalMemory()/1024/1024);
    System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
    System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
  }

}
