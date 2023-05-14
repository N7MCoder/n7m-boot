package cc.nunumao.system.app;
// +----------------------------------------------------------------------
// | 官方网站: www.nunumao.cc
// +----------------------------------------------------------------------
// | 功能描述: 请输入功能描述
// +----------------------------------------------------------------------
// | 时　　间: 2023-05-08
// +----------------------------------------------------------------------
// | 代码创建: 努努猫 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V 0.0.1
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------


import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.WeakCache;
import cn.hutool.core.date.DateUnit;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class SystemApplicationTest {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerInterceptor loadBalancerInterceptor;

    @Test
    void contextLoads() {

        WeakCache<String, String> weakCache = CacheUtil.newWeakCache(DateUnit.SECOND.getMillis() * 3);
        weakCache.put("abc","111");
        weakCache.put("abc","222");
        System.out.println(weakCache.get("abc"));

//        restTemplate.setInterceptors(new ArrayList<>(){{
//            add(loadBalancerInterceptor);
//        }});
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("grant_type", "client_credentials");
//        body.add("client_id", "messaging-client");
//        body.add("client_secret", "bm6g0tUuNnOJdqLfMzFlZoaxA8jp192Q");
//
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://passport/passport/oauth2/token", httpEntity, String.class);
//        log.error(responseEntity.toString());
    }

}
