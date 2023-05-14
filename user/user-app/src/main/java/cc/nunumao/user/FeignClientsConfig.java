package cc.nunumao.user;
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

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class FeignClientsConfig {

    @Resource
    private ObjectFactory<HttpMessageConverters> messageConverter;

    @Resource
    private RestTemplate restTemplate;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {

//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//        // 请求体
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("grant_type", "client_credentials");
//        body.add("client_id", "messaging-client");
//        body.add("client_secret", "bm6g0tUuNnOJdqLfMzFlZoaxA8jp192Q");
//
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8851/passport/oauth2/token", httpEntity, String.class);
//        Object token = JSONUtil.parseObj(responseEntity.getBody()).get("access_token");
        log.error("oauth2FeignRequestInterceptor");
        return requestTemplate ->
                requestTemplate.header("Authorization", "Bearer ");
    }

//    @Bean
//    public Decoder feignDecoder() {
//        return (response, type) -> {
//            log.error(response.body().toString());
//            return new SpringDecoder(this.messageConverter);
//        };
//    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            log.error(methodKey);
            return new RuntimeException("错误了");
        };
    }

}
