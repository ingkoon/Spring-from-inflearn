package Koon.sDiary.server.controller;

import Koon.sDiary.server.domain.User;
import Koon.sDiary.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, User user) {
        this.userService = userService;
    }

    @PostMapping("/users/new")
    public String create(UserForm form){
        User user= new User();

        user.setUserId(form.getUserId());
        user.setPassword(form.getPassword());
        user.setNickname(form.getNickName());
        user.setBirth(form.getBirth());

        userService.join(user);
        return user.getUserId();
    }
}
