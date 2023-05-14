package cc.nunumao.system.app.config.feign;
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

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Autowired
    private FeignTokenService feignTokenService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = feignTokenService.get();
        if (StringUtils.hasLength(token)) {
            requestTemplate.header("Authorization", "Bearer " + token);
        }
    }

}
