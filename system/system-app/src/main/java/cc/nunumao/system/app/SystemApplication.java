package cc.nunumao.system.app;
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

import io.github.nunumao.app.App;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"cc.nunumao"})
@MapperScan(value = {App.CORE_PACKAGE_MAPPER, "cc.nunumao.system.dao"})
@SpringBootApplication(scanBasePackages = {App.CORE_PACKAGE, "cc.nunumao"})
public class SystemApplication {

    public static void main(String[] args) {
        App.run(SystemApplication.class, args);
    }

}
