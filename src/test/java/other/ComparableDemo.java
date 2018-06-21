package other;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 测试排序Comparable.
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/12
 */
public class ComparableDemo {

  List<User> list = Arrays.asList(
      new User("张三", 11),
      new User("王五", 20),
      new User("王五", 91),
      new User("张三", 8),
//      new User("李四", 44),
//      new User("李四", 44),
      new User("李四", 44)
  );

  @Test
  public void comparableTest() {

    list.forEach(u -> System.out.println(u));
//    System.out.println("增加年龄--->");
//    System.out.println("判断年龄后--->");
    Consumer<User> addAge = u -> u.setAge(u.getAge() + 1);
//    Consumer<String> stringConsumer = s -> System.out.println(s);
    list.forEach(addAge);
    list.stream().filter(user -> user.getAge() > 50)
        .forEach(user -> System.out.println(user.toString()));

//    list.stream().filter(new Predicate<User>() {
//      @Override
//      public boolean test(User user) {
//        if (user.getAge() > 50) {
//          return true;
//        }
//        return false;
//      }
//    }).forEach(u -> System.out.println(u.toString()));

    Predicate<User> ageFilter = (user) ->
        user.getAge() > 20;
    Predicate<User> nameFilert = (User user) ->
        "陈浩".equals(user.getName());
    System.out.println("多重判断后------>");
    list.stream().limit(3).sorted(new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getAge().compareTo(o2.getAge());
      }
    }).filter(ageFilter).forEach(u -> System.out.println(u));

//    list.stream().filter(user ->
//        user.getAge() > 50 && "陈浩".equals(user.getName())
//    ).forEach(user -> System.out.println(user.toString()));

//    Stream<User> userStream = list.stream().filter(user -> user.getAge() > 50);
//    userStream.forEach(user -> System.out.println(user.toString()));
//    stringConsumer.accept("1");
//    Collections.sort(list, (User o1, User o2) -> {
//      if (o1.getName().compareTo(o2.getName()) == 0) {
//        return o1.getAge().compareTo(o2.getAge());
//      } else {
//        return o1.getName().compareTo(o2.getName());
//      }
//    });
//    Collections.sort(list);
//    list.forEach(u -> System.out.println(u));

  }

  @Test
  public void lambdaTest() {

    String[] players = {"h Martin Del Potro", "g Berdych",
        "i Gasquet", "d Ferrer",
        "e Federer", "j Isner",
        "b Djokovic", "a Waa",
        "c Wawrinka", "f Murray"};

    // 1.使用匿名内部类进行排序，根据String的名字.
    Arrays.sort(players, (String o1, String o2) -> {
          // 这里是别的代码.
          // code
          System.out.println();
          System.out.println();
          return o1.compareTo(o2);
        }
    );
    // 2.对上述代码优化，使用lambda表达式.
    Arrays.sort(players, (o1, o2) -> {
      // 这里是别的代码.
      // code
      System.out.println();
      System.out.println();
      return o1.compareTo(o2);
    });
    // 3.对上述代码再次优化.
    Arrays.sort(players, String::compareTo);

    for (String a : players) {
      System.out.println(a);
    }

  }

  @Test
  public void testInt() {
    Integer[] ages = {11, 4, 54, 34, 53, 77, 2, 13, 52, 86};
//    Arrays.sort(ages,new MyComparator());
    for (Integer i : ages) {
      System.out.println(i);
    }
  }

  @Test
  public void ex() {
    float f[] = {1};
    float a = 1;
    float b = 1f;
    double e = 0.7;
    e = 1.2;
    Map<String, String> map = new HashMap<>();
    Set<Entry<String, String>> entries = map.entrySet();
    for (Entry<String, String> entry : entries) {
      entry.getKey();
      entry.getValue();
    }

    Set<String> strings = map.keySet();
    strings.forEach(u -> System.out.println(map.get(u)));
  }

  /**
   * 测试 排序
   */
  @Test
  public void testSort1() {
    Predicate<User> ageFilter = (User user) -> user.getAge() > 20;

    Comparator<User> comparable = (o1, o2) -> o1.getAge().compareTo(o2.getAge());

    List<User> collect = list.stream().sorted(comparable).filter(ageFilter).limit(3)
        .collect(toList());
    collect.forEach(user -> System.out.println(user));
  }

  /**
   * 查找年级最大最小使用min max
   */
  @Test
  public void maxMin() {
    User min = list.stream().min(new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getAge().compareTo(o2.getAge());
      }
    }).get();
    System.out.println(min);

    User max = list.stream().max(Comparator.comparing(User::getAge)).get();

    int sum = list.stream().mapToInt(u -> u.getAge()).sum();

    System.out.println("∑----->" + sum);

    System.out.println(max);
  }

  /**
   * 测试计算.
   */
  @Test
  public void testNum() {
    IntSummaryStatistics num = list.stream().mapToInt(u -> u.getAge())
        .summaryStatistics();
    System.out.println("总共人数：" + num.getCount());
    System.out.println("平均年龄：" + num.getAverage());
    System.out.println("最大年龄：" + num.getMax());
    System.out.println("最小年龄：" + num.getMin());
    System.out.println("年龄之和：" + num.getSum());
  }

  /**
   * 测试skip 跳过
   */
  @Test
  public void testSkip1() {
    list.stream().forEach(user -> System.out.println(user));
    System.out.println("skip---end----->");
    list.stream().skip(3).forEach(u -> System.out.println(u));
  }

  /**
   * 测试去重distinct，泛型类型必须重写hashcode，equal，否则不会去重
   */
  @Test
  public void testDistinct1() {
    list.stream().forEach(user -> System.out.println(user));
    System.out.println("去重后");
    list.stream().distinct().forEach(user -> System.out.println(user));
  }

  /**
   * map 映射.
   */
  @Test
  public void testMap() {
    // 只输出所有人的年龄
    list.stream().forEach(user -> System.out.println(user));
    System.out.println("映射后----->");
    List<Integer> ages = list.stream().map(user -> user.getAge()).collect(toList());
    ages.forEach(age -> System.out.println(age));

    // 小写转大写
    List<String> words = Arrays.asList("aaa", "vvvv", "cccc");
    System.out.println("全部大写---->");
    List<String> collect = words.stream().map(s -> s.toUpperCase()).collect(toList());
    collect.forEach(s -> System.out.println(s));
  }

  /**
   * flatMap .
   */
  @Test
  public void testFlatMap() {
    //创建一个 装有两个泛型为integer的集合
    Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
    // 将两个合为一个
    Stream<Integer> integerStream = stream.flatMap(
        (Function<List<Integer>, Stream<Integer>>) integers -> integers.stream());
    // 为新的集合
    List<Integer> collect = integerStream.collect(toList());
    System.out.println("新stream大小:" + collect.size());
    System.out.println("-----合并后-----");
    collect.forEach(o -> System.out.println(o));
  }

  /**
   * 获取流
   */
  @Test
  public void getStream() {
    // 1、数组
    String[] arr = new String[]{"ab", "cd", "ef"};
    Stream<String> arrStream = Arrays.stream(arr);
    // 2、集合
    List<String> list = Arrays.asList("ab", "cd", "ef");
    Stream<String> colStream = list.stream();
    // 3、值
    Stream<String> stream = Stream.of("ab", "cd", "ef");
  }

  /**
   * forEach 迭代输出每条数据
   */
  @Test
  public void testForEach() {
    // java 8 前
    System.out.println("java 8 前");
    for (User user : list) {
      System.out.println(user);
    }
    // java 8 lambda
    System.out.println("java 8 lambda");
    list.forEach(user -> System.out.println(user));

    // java 8 stream lambda
    System.out.println("java 8 stream lambda");
    list.stream().forEach(user -> System.out.println(user));
  }

  /**
   * sort 排序.
   */
  @Test
  public void testSort() {
    System.out.println("-----排序前-----");
    list.forEach(user -> System.out.println(user));
    System.out.println("-----排序后-----");
    // java 8 前
    System.out.println("java 8 前");
    Collections.sort(list, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getAge().compareTo(o2.getAge());
      }
    });
    for (User user : list) {
      System.out.println(user);
    }
    // java 8 stream 方法引用
    System.out.println("java 8 stream 方法引用");
    list.stream().sorted(Comparator.comparing(User::getAge))
        .forEach(user -> System.out.println(user));
  }

  /**
   * filter 过滤.
   */
  @Test
  public void testFilter() {
    // 输出年龄大于50的人
    System.out.println("-----过滤前-----");
    list.forEach(user -> System.out.println(user));
    System.out.println("-----过滤后-----");
    // java 8 前
    System.out.println("java 8 前");
    for (User user : list) {
      if (user.getAge() > 50) {
        System.out.println(user);
      }
    }
    // java 8 stream
    System.out.println("java 8 stream");
    list.stream().filter((User user) -> user.getAge() > 50)
        .forEach(user -> System.out.println(user));
  }

  /**
   * limit 截断.
   */
  @Test
  public void testLimit() {
    // 从第三个开始截断，只输出前三个
    System.out.println("-----截断前-----");
    list.forEach(user -> System.out.println(user));
    System.out.println("-----截断后-----");
    // java 8 前
    System.out.println("java 8 前");
    for (int i = 0; i < 3; i++) {
      System.out.println(list.get(i));
    }
    // java 8 stream
    System.out.println("java 8 stream");
    list.stream().limit(3).forEach(user -> System.out.println(user));
  }

  /**
   * skip 跳过.
   */
  @Test
  public void testSkip() {
    // 跳过前三个元素，从第四个开始输出
    System.out.println("-----跳过前-----");
    list.forEach(user -> System.out.println(user));
    System.out.println("-----跳过后-----");
    // java 8 前
    System.out.println("java 8 前");
    for (int i = 3; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    // java 8 stream
    System.out.println("java 8 stream");
    list.stream().skip(3).forEach(user -> System.out.println(user));
  }

  /**
   * distinct 去重.
   */
  @Test
  public void testDistinct() {
    // 因为Arrays.asList() 返回的是Arrays的内部类ArrayList，操作remove，add会报错
    List<User> users = new ArrayList(list);
    // 为list去除重复数据
    System.out.println("-----去重前-----");
    list.forEach(user -> System.out.println(user));
    System.out.println("-----去重后-----");
    // java 8 前
    System.out.println("java 8 前");
    for (int i = 0; i < users.size() - 1; i++) {
      for (int j = users.size() - 1; j > i; j--) {
        if (users.get(j).getAge() == users.get(i).getAge() && users.get(j).getName()
            .equals(users.get(i).getName())) {
          users.remove(i);
        }
      }
    }
    for (User user : users) {
      System.out.println(user);
    }
    // java 8 stream
    System.out.println("java 8 stream");
    users.stream().distinct().forEach(user -> System.out.println(user));
  }


  /**
   * 去重+按照年龄大于40以后从小到大+只取前二
   */
  @Test
  public void demo() {
    list.stream().distinct().filter(user -> user.getAge() > 40).sorted(
        Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out
        .println(user));
  }

  /**
   * findFirst 获取第一个元素.
   */
  @Test
  public void testFindFirst() {
    User user = list.stream().findFirst().get();
    System.out.println(user);
  }

  /**
   * findAny() 随机选出一个元素.
   */
  @Test
  public void testFindAny() {
    List<User> users = new ArrayList<>(list);
    users.remove(0);
    for (int i = 0; i < 10; i++) {
      Optional<User> user = users.stream().findAny();
      System.out.println(user);
    }
  }

  /**
   * anyMatch 是否匹配任意元素
   */
  @Test
  public void testAnyMatch() {
    boolean anyMatch = list.stream().anyMatch(user -> {
      if (user.getAge() > 50) {
        return true;
      } else {
        return false;
      }
    });
    System.out.println(anyMatch);
  }

  /**
   * iterate
   */
  @Test
  public void testIterate() {
//    IntStream.generate(() -> (int) (System.nanoTime() % 100)).
//        limit(10).forEach(System.out::println);
//    Stream.iterate(0,n->n+3).limit(20).forEach(u-> System.out.println(u));
    Stream.iterate(0, n -> n + 1).limit(10).forEach(u -> System.out.println(u));
  }


  @Test
  public void testStringToInt() {
//    List<String> l = Arrays.asList("1", "2", "3");
//    List<Integer> collect = l.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
//    collect.forEach(u-> System.out.println(u));

//    list.stream().collect(Collectors.toMap(obj -> obj.getAge(), obj -> obj));
//    list.stream().collect(Collectors.toMap(obj -> obj.getAge(), obj -> obj));
    Map<Integer, String> map = list.stream()
        .collect(Collectors.toMap(user -> user.getAge(), user -> user.getName()));
    for(Entry<Integer,String> entry: map.entrySet()){
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    Set<Integer> integers = map.keySet();
    integers.forEach(u -> System.out.println(map.get(u)));

  }


  /**
   * 线程.
   */
  @Test
  public void therdTest() {
    System.out.println(Integer.MIN_VALUE);
    System.out.println((long) (Integer.MAX_VALUE + 1));
//    Collections.sort(list, Comparator.comparing(User::getName));
//    Runnable runnable = () -> System.out.println(1);
  }

}

