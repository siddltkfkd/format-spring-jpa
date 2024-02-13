package com.nhnacademy.jpa1.config;

import com.nhnacademy.jpa1.repository.BaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(
//        요 둘중 하나 씀년 됌
//        basePackages="com.nhnacademy.jpa1.repository"
        basePackageClasses = BaseRepository.class
)
@Configuration
public class JpaConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean enf = new LocalContainerEntityManagerFactoryBean();
        enf.setDataSource(dataSource);
        enf.setPackagesToScan("com.nhnacademy.jpa1.entity");
        enf.setJpaVendorAdapter(jpaVendorAdapter());
        enf.setJpaProperties(jpaProperties());

        return enf;
    }

    private Properties jpaProperties(){
        Properties jspProperties = new Properties();
        jspProperties.setProperty("hibernate.show_sql", "true");
        return jspProperties;
    }

    private JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
