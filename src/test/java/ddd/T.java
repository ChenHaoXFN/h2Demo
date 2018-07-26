package ddd;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/18
 */
public class T {

  public static void main(String[] args) {
    Person person = new Person();
    In i = new In(person);
    Out o = new Out(person);
    Thread t1 = new Thread(i);
    Thread t2 = new Thread(o);
    t1.start();
    t2.start();
  }

  public static class In implements Runnable {

    private int num = 1;
    private Person person;

    public In(Person person) {
      this.person = person;
    }

    @Override
    public void run() {
      while (true) {

        synchronized (person) {
          if (num % 2 == 1) {
            person.name = "张金";
            person.sex = "男";
          } else {
            person.name = "jerry";
            person.sex = "woman";
          }
          num++;
        }

      }
    }
  }

  public static class Out implements Runnable {

    private Person person;

    public Out(Person person) {
      this.person = person;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (person) {
          System.out.println(person.name + "......" + person.sex);
        }
      }
    }
  }

}
