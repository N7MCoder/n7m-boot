package cc.nunumao.passport.config.security.service;
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

import cc.nunumao.user.xapi.UserXapi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecurityUserDetailService implements UserDetailsService {

    @Autowired
    private UserXapi userXapi;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        cc.nunumao.user.model.User user = userXapi.queryUserByAccount(account);
        log.error(user.toString());
        return User.withUsername("admin")
                .password("$2a$10$wraCNTctFnPomCUhmveNDOpkU8J.WdnbdsFQb8wk6eyLjsxqVBfbG")
                .roles("ROLE_USER")
                .build();
    }

}
