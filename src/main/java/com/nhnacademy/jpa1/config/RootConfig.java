package com.nhnacademy.jpa1.config;

import com.nhnacademy.jpa1.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration // javaConfig class임을 알려줌
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
//    @Bean // -> 이걸 붙여서 직접 Bean을 붙일 수 있다 -> DataSource 타입의 빈들을 넣을 수 있음
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        // 기본적으로 요렇게 4개 넣어주면 된다
        dataSource.setDriverClassName("org.h2.Driver");
        // classpath의 경로는 resources 다음이다
        dataSource.setUrl("jdbc:h2:~/spring-jpa;INIT=RUNSCRIPT from 'classpath:/script/schema.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(10);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }
}
