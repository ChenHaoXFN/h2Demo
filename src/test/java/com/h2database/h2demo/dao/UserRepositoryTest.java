package com.h2database.h2demo.dao;

import com.h2database.h2demo.domain.User;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * DAO测试类.
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void addUser() {
    User user;
    long start = System.currentTimeMillis();   //获取开始时间
    for (int i = 1; i < 100000; i++) {
      User one = userRepository.findOne(i);
      Integer id = one.getId();
      Integer age = one.getAge();
      Integer num = id*age;

    }
    long end = System.currentTimeMillis(); //获取结束时间
    System.out.println("程序运行时间： " + (end - start) / 1000 + " 秒");
  }

  private Integer getAge() {
    return new Random().nextInt(100) + 1;
  }

  @Test
  public void editUser() {
//    User user = new User();
//    user.setId(1);
//    user.setName("李四");
//    user.setAddress("上海");
//    user.setAge(20);
//    user.setCity("上海");
//    userRepository.save(user);
  }

  @Test
  public void queryUser() {
    User user = userRepository.findOne(1);
    System.out.println(user);
    Assert.assertEquals("李四", user.getName());
    Assert.assertEquals("上海", user.getAddress());

  }

  @Test
  public void delUser() {
    userRepository.delete(1);
  }


}