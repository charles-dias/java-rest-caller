package br.com.charlesdias.javarestcaller;

import br.com.charlesdias.javarestcaller.model.User;
import br.com.charlesdias.javarestcaller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaRestCallerApplication {

	//private static UserService userService;

	//@Autowired
	//public JavaRestCallerApplication(UserService service) {
	//	this.userService = service;
	//}

	public static void main(String[] args) {
		SpringApplication.run(JavaRestCallerApplication.class, args);

		//User user = userService.get();

		//System.out.printf(">>>>>>>> ", user.id, " <<<<<<<<");
	}
}
