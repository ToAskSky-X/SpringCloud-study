package org.goskyer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: monster_x
 * @create: 2018-09-06 18:09
 **/
@SpringBootApplication
public class LogbackConfigApplication {


    private static final Logger logger = LoggerFactory.getLogger(LogbackConfigApplication.class);

    public static void main(String[] args) {
        //打印 Logback 内部状态
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
        SpringApplication.run(LogbackConfigApplication.class);
    }

}


