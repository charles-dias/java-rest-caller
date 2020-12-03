package br.com.charlesdias.javarestcaller.service;

import br.com.charlesdias.javarestcaller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate api;

    @Autowired
    public UserService(ApiService service) throws Exception {
        this.api = service.createInstance(false);
    }

    public User get() throws Exception {
        return api.getForEntity("https://api.github.com/users/charles-dias", User.class).getBody();
    }
}
