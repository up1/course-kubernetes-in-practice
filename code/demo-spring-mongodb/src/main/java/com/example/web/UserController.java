package com.example.web;

import com.example.model.Address;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public @ResponseBody
    User retrieveUser(@PathVariable("id") String id) {
        log.info("Retrieving user with id: " + id);

        User user = userRepository.findOne(id);
        if(user == null) {
            user = new User();
            user.setAddress(new Address());
            user.setFirstName("Arun");
            userRepository.save(user);
        }
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    User addUser(@RequestBody User user) {
        user = userRepository.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<User> retriveUsers() {
        log.info("Retrieving all users");
        List<User> users = userRepository.findAll();
        return users;
    }
}
