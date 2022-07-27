package org.ck.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: SpringBootLockTest
 * @description:
 * @createDate: 2022年06月15日 18:05:23
 * @author: ck
 */
@SpringBootApplication
public class SpringBootLockTest {

    @Autowired
    private Lock lock7;

    @Autowired
    private DistributedLock distributedLock;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLockTest.class, args);
    }
}

@Configuration
class Config {

    @Bean
    public Lock lock() {
        return new DistributedLock();
    }

/*    @Bean
    public DistributedLock lock() {
        return new DistributedLock();
    }*/

}

interface Lock {

}

class DistributedLock implements Lock {
}