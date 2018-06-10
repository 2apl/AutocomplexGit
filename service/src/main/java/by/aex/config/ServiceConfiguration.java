package by.aex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"by.aex.service", "by.aex.converter"})
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@Import(DaoConfiguration.class)
public class ServiceConfiguration {
}
