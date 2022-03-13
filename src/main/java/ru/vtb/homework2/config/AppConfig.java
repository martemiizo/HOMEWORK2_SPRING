package ru.vtb.homework2.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"ru.vtb.dz2.services"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
