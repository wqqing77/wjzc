package com.wjzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author wjzc
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
        System.out.println("    ____             __            __\n" + "   / __ )____  _____/ /____  _____/ /_\n" + "  / __  / __ \\/ ___/ __/ _ \\/ ___/ __ \\\n" + " / /_/ / /_/ (__  ) /_/  __/ /__/ / / /\n" + "/_____/\\____/____/\\__/\\___/\\___/_/ /_/");
    }
}
