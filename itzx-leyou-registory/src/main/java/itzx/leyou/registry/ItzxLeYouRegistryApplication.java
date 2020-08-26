package itzx.leyou.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * itzx.leyou.registory
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/10 15:24
 */
@SpringBootApplication
@EnableEurekaServer
public class ItzxLeYouRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItzxLeYouRegistryApplication.class,args);
    }
}
