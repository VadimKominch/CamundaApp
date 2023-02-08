package org.example.application;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CamundaConfiguration {
    @Bean
    @Qualifier("camundaBpmDataSource")
    public DataSource camundaBpmDataSource(CamundaDataSourceConfig config) {
        return new HikariDataSource(config);
    }

}


@Configuration
@ConfigurationProperties("camunda.datasource")
class CamundaDataSourceConfig extends HikariConfig {
    public CamundaDataSourceConfig() {
        super();
    }
}