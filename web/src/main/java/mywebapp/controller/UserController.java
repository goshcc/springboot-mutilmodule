package mywebapp.controller;

import mywebapp.constant.Constant;
import mywebapp.domain.User;
import mywebapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private static Logger logger = LoggerFactory.getLogger(Constant.LOGGER_NAME);

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            logger.info("save user {}", user.toString());
        }

        return user;
    }
}
