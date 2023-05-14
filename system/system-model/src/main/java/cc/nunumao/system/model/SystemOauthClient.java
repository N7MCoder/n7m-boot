package cc.nunumao.system.model;
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

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class SystemOauthClient {

    public static final String ID = "id";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_ID_ISSUED_AT = "client_id_issued_at";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String CLIENT_SECRET_EXPIRES_AT = "client_secret_expires_at";
    public static final String CLIENT_NAME = "client_name";
    public static final String CLIENT_AUTHENTICATION_METHODS = "client_authentication_methods";
    public static final String AUTHORIZATION_GRANT_TYPES = "authorization_grant_types";
    public static final String REDIRECT_URIS = "redirect_uris";
    public static final String SCOPES = "scopes";
    public static final String CLIENT_SETTINGS = "client_settings";
    public static final String TOKEN_SETTINGS = "token_settings";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";
    public static final String STATUS = "status";


    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    @TableField(value = CLIENT_ID)
    private String clientId;
    @TableField(value = CLIENT_ID_ISSUED_AT)
    private String clientIdIssuedAt;
    @TableField(value = CLIENT_SECRET)
    private String clientSecret;
    @TableField(value = CLIENT_SECRET_EXPIRES_AT)
    private String clientSecretExpiresAt;
    @TableField(value = CLIENT_NAME)
    private String clientName;
    @TableField(value = CLIENT_AUTHENTICATION_METHODS)
    private String clientAuthenticationMethods;
    @TableField(value = AUTHORIZATION_GRANT_TYPES)
    private String authorizationGrantTypes;
    @TableField(value = REDIRECT_URIS)
    private String redirectUris;
    @TableField(value = SCOPES)
    private String scopes;
    @TableField(value = CLIENT_SETTINGS)
    private String clientSettings;
    @TableField(value = TOKEN_SETTINGS)
    private String tokenSettings;
    @TableField(value = CREATE_TIME)
    private Timestamp createTime;
    @TableField(value = UPDATE_TIME)
    private Timestamp updateTime;
    @TableField(value = STATUS)
    private Integer status;

}
