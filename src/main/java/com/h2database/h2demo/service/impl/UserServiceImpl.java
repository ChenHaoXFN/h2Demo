package com.h2database.h2demo.service.impl;

import com.h2database.h2demo.dao.UserRepository;
import com.h2database.h2demo.domain.User;
import com.h2database.h2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/21
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;


  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }
}
