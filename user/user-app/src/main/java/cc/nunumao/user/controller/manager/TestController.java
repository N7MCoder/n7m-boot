package cc.nunumao.user.controller.manager;
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

import cc.nunumao.system.model.SystemOauthClient;
import cc.nunumao.system.xapi.SystemOauthClientXapi;
import cc.nunumao.user.controller.Manager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Tag(name = "测试")
@Secured(value = "ROLE_ADMIN")
@RestController
@RequestMapping(value = "test")
public class TestController extends Manager {

    @Autowired
    private SystemOauthClientXapi systemOauthClientXapi;

    @Operation(summary = "你好")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Object hello() {
        List<String> names = new ArrayList<>();
        for (SystemOauthClient systemOauthClient : systemOauthClientXapi.list()) {
            names.add(systemOauthClient.getClientName());
        }
        return names;
    }

}
