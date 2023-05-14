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

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.WeakCache;
import cn.hutool.core.date.DateUnit;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Slf4j
@Component
public class FeignTokenService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerInterceptor loadBalancerInterceptor;

    private WeakCache<String, String> weakCache = CacheUtil.newWeakCache(DateUnit.SECOND.getMillis() * 86400);

    public String getToken() {
        restTemplate.setInterceptors(new ArrayList<>() {{
            add(loadBalancerInterceptor);
        }});
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", "messaging-client");
        body.add("client_secret", "bm6g0tUuNnOJdqLfMzFlZoaxA8jp192Q");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://passport/passport/oauth2/token", httpEntity, String.class);
        String result = responseEntity.getBody();
        log.error(result);
        JSONObject resultObj = JSONUtil.parseObj(result);

        return resultObj.get("access_token").toString();
    }

    public void put(String token) {
        weakCache.put("token", token);
    }

    public String get() {
        return weakCache.get("token");
    }

    public void clear() {
        weakCache.clear();
    }

}
