package cc.nunumao.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@TableName(value = "user")
public class User implements Serializable {

    public static final String ID = "id";
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String NICK_NAME = "nick_name";
    public static final String AVATAR = "avatar";
    public static final String EMAIL = "email";
    public static final String WORK_NO = "work_no";
    public static final String ID_CARD = "id_card";
    public static final String POSITION = "position";
    public static final String BIRTHDAY = "birthday";
    public static final String LOGIN_COUNT = "login_count";
    public static final String LAST_LOGIN_IP = "last_login_ip";
    public static final String LAST_LOGIN_TIME = "last_login_time";
    public static final String LOGIN_ERROR = "login_error";
    public static final String IS_LOCK = "is_lock";
    public static final String ORIGIN = "origin";
    public static final String IS_ADMIN = "is_admin";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";
    public static final String STATUS = "status";

    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;


}
