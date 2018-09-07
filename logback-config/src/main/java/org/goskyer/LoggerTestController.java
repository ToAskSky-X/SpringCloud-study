package org.goskyer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: monster_x
 * @create: 2018-09-07 10:36
 **/
@RestController
public class LoggerTestController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTestController.class);


    @RequestMapping("/test")
    public void test() {
        logger.info("info.....");
        logger.error("error.....");
        logger.debug("debug.....");
        logger.trace("trace.....");

    }
}
