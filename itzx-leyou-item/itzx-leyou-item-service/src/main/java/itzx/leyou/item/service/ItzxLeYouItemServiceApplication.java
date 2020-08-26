package itzx.leyou.item.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * itzx.leyou.item.service
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/10 16:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("itzx.leyou.item.service.mapper")
public class ItzxLeYouItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItzxLeYouItemServiceApplication.class,args);
    }
}
