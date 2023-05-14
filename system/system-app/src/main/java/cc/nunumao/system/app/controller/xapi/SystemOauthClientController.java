package cc.nunumao.system.app.controller.xapi;
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
import cc.nunumao.system.service.SystemOauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "oauthClient")
public class SystemOauthClientController {

    @Autowired
    private SystemOauthClientService systemOauthClientService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<SystemOauthClient> list() {
        return systemOauthClientService.list();
    }

}
