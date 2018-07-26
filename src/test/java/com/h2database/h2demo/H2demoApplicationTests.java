package com.h2database.h2demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2demoApplicationTests {

	@Test
	public void contextLoads() {
		int x = 10 / 3;
		System.out.println(( x > 3 ) ? ( x += 3 / 10 ) : ( x -= 3 / 10 ));
	}

}
