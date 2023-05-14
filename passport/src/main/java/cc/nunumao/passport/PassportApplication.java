package cc.nunumao.passport;

import io.github.nunumao.global.Global;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"cc.nunumao"})
@SpringBootApplication(scanBasePackages = {Global.CORE_PACKAGE, "cc.nunumao"})
public class PassportApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PassportApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }

}
