package other;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/27
 */
public class ThreadJoin {

  public static void main(String[] args) {
    RuMe r = new RuMe();
    new Thread(() -> {
      for (int i = 1; i < 11; i++) {
        r.Th1(i);
      }
    }).start();
    for (int i = 1; i < 11; i++) {
      r.Th2(i);
    }
  }

  public static class RuMe {
    Object o = new Object();
    private boolean flag = true;
    public void Th1(int numA) {
      synchronized (o) {
        while (!flag) {
          try {
            o.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 1; i < 11; i++) {
          System.out.println("线程一跑到第: " + i + "次，总共循环" + numA + "次");
        }
        flag = false;
        o.notify();
      }
    }

    public void Th2(int numA) {
      synchronized (o) {
        while (flag) {
          try {
            o.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 1; i < 51; i++) {
          System.out.println("线程二跑到第: " + i + "次，总共循环" + numA + "次");
        }
        flag = true;
        o.notify();
      }
    }

  }
}