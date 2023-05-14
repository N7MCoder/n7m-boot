package cc.nunumao.system.service.impl;
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

import cc.nunumao.system.dao.SystemOauthClientDao;
import cc.nunumao.system.model.SystemOauthClient;
import cc.nunumao.system.service.SystemOauthClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemOauthClientServiceImpl extends ServiceImpl<SystemOauthClientDao, SystemOauthClient> implements SystemOauthClientService {
}
