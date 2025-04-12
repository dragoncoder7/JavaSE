package demo.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//@MapperScan(basePackages = "ewpt.srm.mapper", sqlSessionFactoryRef = "ecologySqlSessionFactory")
//@Configuration
public class EcologyDataSourceConfig {
    @Bean(name = "ecologyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource ecologyDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }
    @Bean(name = "ecologySqlSessionFactory")
    public SqlSessionFactory ecologySqlSessionFactory(@Qualifier("ecologyDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "ecologySqlSessionTemplate")
    public SqlSessionTemplate ecologySqlSessionTemplate(@Qualifier("ecologySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
