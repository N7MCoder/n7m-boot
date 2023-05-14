package cc.nunumao.user.controller.manager;

import cc.nunumao.user.controller.Manager;
import cc.nunumao.user.model.User;
import cc.nunumao.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户管理")
@RestController
@RequestMapping(value = "user")
public class UserController extends Manager<UserService, User> {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户列表")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object test() {
        return userService.list();
    }

}
