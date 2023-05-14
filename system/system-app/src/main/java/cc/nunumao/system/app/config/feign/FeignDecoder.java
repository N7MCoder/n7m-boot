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

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Objects;

@Slf4j
public class FeignDecoder implements Decoder {

    private final Decoder delegate;

    private FeignTokenService feignTokenService;

    public FeignDecoder(Decoder delegate, FeignTokenService feignTokenService) {
        Objects.requireNonNull(delegate, "Decoder must not be null. ");
        Objects.requireNonNull(delegate, "RestTemplate must not be null. ");
        this.delegate = delegate;
        this.feignTokenService = feignTokenService;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {

        String result = IoUtil.read(response.body().asInputStream(), Charset.defaultCharset());

        JSONObject resultObj = JSONUtil.parseObj(result);
        Integer code = resultObj.getInt("code");
        if (!ObjectUtils.isEmpty(code)) {
            feignTokenService.clear();
            if (code.equals(402)) {
                log.warn("service token expired");
                setToken();
            } else if (code.equals(401)) {
                log.warn("service authentication is required");
                setToken();
            }
            throw new RetryableException(response.status(), "token exception", response.request().httpMethod(), new Date(), response.request());
        }

        return delegate.decode(response.toBuilder().body(result, Charset.defaultCharset()).build(), type);
    }

    private void setToken() {
        String token = feignTokenService.getToken();
        feignTokenService.put(token);
    }


}
