package cc.nunumao.user.service.impl;

import cc.nunumao.user.dao.UserDao;
import cc.nunumao.user.model.User;
import cc.nunumao.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
