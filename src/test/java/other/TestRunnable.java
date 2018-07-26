package other;

import static java.lang.Thread.sleep;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/25
 */
public class TestRunnable {

  public static void main(String[] args) {
    Thread one = new Thread(() -> {
      System.out.println("好困，想睡觉~~");
      try {
        System.out.println("开始睡觉了~~");
        sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("睡醒了~~~");
    });
     one.start();
    one.interrupt();
  }
}
