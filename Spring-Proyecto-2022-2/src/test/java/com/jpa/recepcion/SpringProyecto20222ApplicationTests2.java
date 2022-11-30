package com.jpa.recepcion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringProyecto20222ApplicationTests2 {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String x=encoder.encode("123");
		System.out.println(x);
	}

}
