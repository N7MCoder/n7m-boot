package cc.nunumao.passport;
// +----------------------------------------------------------------------
// | 官方网站: www.nunumao.cc
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2023-04-10
// +----------------------------------------------------------------------
// | 代码创建: 努努猫 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V 0.0.1
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import cc.nunumao.user.model.User;
import cc.nunumao.user.xapi.UserXapi;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PassportApplicationTest {

    @Autowired
    private UserXapi userXapi;

    @Test
    void contextLoads() {
        User user = userXapi.queryUserByAccount("jb18cm");
        log.error(user.toString());
    }

}
