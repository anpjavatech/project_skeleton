package com.xylem.dewatering.fst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Anoop.ks on 11-12-2017
 */
@SpringBootApplication
public class FstApplication {

    private static final Logger logger = LoggerFactory.getLogger(FstApplication.class);

    public static void main(String[] args) {
        logger.info("Main class for FST application.");
        Class[] configurations = {FstApplication.class};
        SpringApplication.run(configurations, args);
    }
}
