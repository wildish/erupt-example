package com.example.demo;

import com.example.demo.handler.TestLoginProxy;
import com.example.demo.interceptor.SimpleInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.erupt.core.annotation.EruptScan;
import xyz.erupt.upms.fun.EruptLogin;

import java.awt.*;
import java.net.URI;

@EruptLogin(TestLoginProxy.class)
@SpringBootApplication
@EntityScan
@EruptScan
public class ExampleApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

    //详细使用方法详见项目内 README.md 文件说明
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
//        try {
//            System.setProperty("java.awt.headless", "false");
//            Desktop.getDesktop().browse(new URI("http://localhost:8080"));
//        } catch (Exception ignore) {
//        }
    }

    //打WAR包的配置
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExampleApplication.class);
    }

    // 添加api截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SimpleInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/token");
    }
}
