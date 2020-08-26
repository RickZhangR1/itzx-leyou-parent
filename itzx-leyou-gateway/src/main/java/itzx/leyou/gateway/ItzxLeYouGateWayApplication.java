package itzx.leyou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * itzx.leyou.gateway
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/10 15:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ItzxLeYouGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItzxLeYouGateWayApplication.class,args);
    }
}
