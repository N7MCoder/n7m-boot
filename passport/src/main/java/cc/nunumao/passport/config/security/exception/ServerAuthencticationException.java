package cc.nunumao.passport.config.security.exception;
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

import cc.nunumao.passport.config.security.enums.ResponseStatusEnum;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

public class ServerAuthencticationException extends OAuth2AuthenticationException {
    private final String code;

    public ServerAuthencticationException(ResponseStatusEnum status) {
        super(new OAuth2Error(status.getMsg()), status.getMsg());
        this.code = status.getCode();
    }

    public ServerAuthencticationException(ResponseStatusEnum status, String msg) {
        super(new OAuth2Error(status.getMsg()), msg);
        this.code = status.getCode();
    }
}
