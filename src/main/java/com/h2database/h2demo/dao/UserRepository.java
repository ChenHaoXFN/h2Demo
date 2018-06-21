package com.h2database.h2demo.dao;

import com.h2database.h2demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/21
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
