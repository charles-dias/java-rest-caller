package br.com.charlesdias.javarestcaller;

import br.com.charlesdias.javarestcaller.model.User;
import br.com.charlesdias.javarestcaller.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaRestCallerApplicationTests {

	private UserService userService;

	@Autowired
	public JavaRestCallerApplicationTests(UserService service) {
		this.userService = service;
	}

	@Test
	void get() throws Exception {
		User user = userService.get();

		System.out.println(user.name);
	}

}
