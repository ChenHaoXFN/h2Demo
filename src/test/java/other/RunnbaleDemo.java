package other;

import java.util.stream.Stream;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/25
 */
public class RunnbaleDemo implements Runnable {

  @Override
  public void run() {
    Stream.iterate(0, n -> n + 1).limit(50).forEach(i -> System.out.println("Runnable--->" + i));
  }
}
