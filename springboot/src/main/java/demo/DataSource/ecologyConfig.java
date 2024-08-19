package demo.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
@MapperScan(basePackages = "demo.mapper.ecology", sqlSessionFactoryRef = "ecologySqlSessionFactory")
public class ecologyConfig {
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
