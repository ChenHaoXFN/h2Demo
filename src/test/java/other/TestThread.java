package other;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/25
 */
public class TestThread {
  public static void main(String[] args) {
    Thread t1 = new Thread(()-> Stream.iterate(1,n->n+1).limit(10).forEach(n-> System.out.println("t1线程---》"+n)));
    Thread t2 = new Thread(()->{
      try {
        t1.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Stream.iterate(1,n->n+1).limit(10).forEach(n-> System.out.println("t2线程---》"+n));
    });
    Thread t3 = new Thread(()->{
      try {
        t2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Stream.iterate(1,n->n+1).limit(10).forEach(n-> System.out.println("t3线程---》"+n));
    });
    t1.start();
    t2.start();
    t3.start();
  }
}
