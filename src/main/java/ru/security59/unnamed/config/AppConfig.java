package ru.security59.unnamed.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ru.security59.unnamed")
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.properties", "classpath:config.properties"})
public class AppConfig {

    private final Environment environment;

    @Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("ru.security59.unnamed");
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        String[] props = {
                "hibernate.dialect",
                "hibernate.show_sql",
                "hibernate.format_sql",
                "hibernate.hbm2ddl.auto",
                //"hibernate.default_schema",
                "hibernate.connection.charset"
        };
        Properties properties = new Properties();
        for (String prop : props) {
            properties.put(prop, environment.getRequiredProperty(prop));
        }
        return properties;
    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory s) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(s);
//        return txManager;
//    }
}