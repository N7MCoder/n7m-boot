package cc.nunumao.user.controller.xapi;
// +----------------------------------------------------------------------
// | 官方网站: https://github.com/N7MCoder/n7m-boot
// +----------------------------------------------------------------------
// | 功能描述:
// +----------------------------------------------------------------------
// | 时　　间: 2023-04-10
// +----------------------------------------------------------------------
// | 代码创建: numao <n7mcoder@gmail.com>
// +----------------------------------------------------------------------
// | 版本信息: V 0.0.1
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import cc.nunumao.user.controller.Xapi;
import cc.nunumao.user.model.User;
import cc.nunumao.user.service.UserService;
import cc.nunumao.user.xapi.UserXapi;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户管理")
@RestController
@RequestMapping(value = "user")
public class UserController extends Xapi<UserService, User> implements UserXapi {

    @Autowired
    private UserService userService;

    @Operation(summary = "账号查询用户")
    @RequestMapping(value = "queryUserByAccount", method = RequestMethod.GET)
    @Override
    public User queryUserByAccount(@RequestParam(value = "account") String account) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq(User.ACCOUNT, account);
        User user = userService.getOne(query);
        if (!ObjectUtils.isEmpty(user)) {
            return user;
        }
        return null;
    }

}
