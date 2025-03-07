package demo.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DataSourceConfig {

    @Bean(name = "ecologyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ecology")
    public DataSource ecologyDataSource() {
        return DataSourceBuilder.create()
//                .url("jdbc:oracle:thin:@10.10.1.92:1521/ecology")
//                .username("ecology")
//                .password("ecology")
//                .driverClassName("oracle.jdbc.OracleDriver")
                .build();
    }

    @Bean(name = "hrDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hr.sqlserver")
    public DataSource hrDataSource() {
        return DataSourceBuilder.create()
//                .url("jdbc:sqlserver://10.10.12.32:1433; DatabaseName=hxhrEwpt;encrypt=false;trustServerCertificate=true")
//                .username("ehr")
//                .password("abcd1234@")
//                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build();
    }
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://127.0.0.1:3306/yupi?characterEncoding=utf8&useSSL=false")
                .username("root")
                .password("root")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}

