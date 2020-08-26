package itzx.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * itzx.leyou.gateway.config
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/21 13:58
 */
@Configuration
public class CROSConfiguration {

    @Bean
    public CorsFilter corsFilter(){
        //初始化Cors配置对象
        CorsConfiguration config=new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("http://manage.leyou.com");
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 4）允许的头信息
//        允许携带任何头信息
        config.addAllowedHeader("*");


        //初始化Cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource =new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",config);
        //返回CorsFilter实例，参数：cors配置源对象
        return new CorsFilter(configurationSource);
    }
}
