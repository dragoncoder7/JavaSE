package demo.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//@Primary
//@Configuration
public class SrmDataSourceConfig {

    @Bean(name = "SrmDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource SrmDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "SrmSqlSessionFactory")
    public SqlSessionFactory SrmSqlSessionFactory(@Qualifier("SrmDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "SrmSqlSessionTemplate")
    public SqlSessionTemplate SrmSqlSessionTemplate(@Qualifier("SrmSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
