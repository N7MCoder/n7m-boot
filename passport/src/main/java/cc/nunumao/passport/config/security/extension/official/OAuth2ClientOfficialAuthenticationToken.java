package cc.nunumao.passport.config.security.extension.official;
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

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.util.SpringAuthorizationServerVersion;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class OAuth2ClientOfficialAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = SpringAuthorizationServerVersion.SERIAL_VERSION_UID;
    private final String clientId;
    private final RegisteredClient registeredClient;
    private final ClientAuthenticationMethod clientAuthenticationMethod;
    private final Object credentials;
    private final Map<String, Object> additionalParameters;

    public OAuth2ClientOfficialAuthenticationToken(
            String clientId,
            ClientAuthenticationMethod clientAuthenticationMethod,
            @Nullable Object credentials,
            @Nullable Map<String, Object> additionalParameters) {
        // 设置权限集合为空
        super(Collections.emptyList());
        Assert.hasText(clientId, "clientId cannot be empty");
        Assert.notNull(clientAuthenticationMethod, "clientAuthenticationMethod cannot be null");
        this.clientId = clientId;
        this.registeredClient = null;
        this.clientAuthenticationMethod = clientAuthenticationMethod;
        this.credentials = credentials;
        this.additionalParameters = Collections.unmodifiableMap(additionalParameters != null ? additionalParameters : Collections.emptyMap());
    }

    public OAuth2ClientOfficialAuthenticationToken(
            RegisteredClient registeredClient,
            ClientAuthenticationMethod clientAuthenticationMethod,
            @Nullable Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        Assert.notNull(registeredClient, "registeredClient cannot be null");
        Assert.notNull(clientAuthenticationMethod, "clientAuthenticationMethod cannot be null");
        this.clientId = registeredClient.getClientId();
        this.registeredClient = registeredClient;
        this.clientAuthenticationMethod = clientAuthenticationMethod;
        this.credentials = credentials;
        this.additionalParameters = Collections.unmodifiableMap(Collections.emptyMap());
        setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return this.clientId;
    }

    @Nullable
    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Nullable
    public RegisteredClient getRegisteredClient() {
        return this.registeredClient;
    }

    public ClientAuthenticationMethod getClientAuthenticationMethod() {
        return this.clientAuthenticationMethod;
    }

    public Map<String, Object> getAdditionalParameters() {
        return this.additionalParameters;
    }

}
