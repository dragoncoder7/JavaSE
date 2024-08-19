package demo.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.lang.NonNull;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionConfig implements TransactionManagementConfigurer {
    @Qualifier("hrDataSource")
    private final DataSource hrDataSource;

    public TransactionConfig(DataSource hrDataSource) {
        this.hrDataSource = hrDataSource;
    }

    @Bean(name = "hrTransactionManager")
    public PlatformTransactionManager hrTransactionManager() {
        return new DataSourceTransactionManager(hrDataSource);
    }

    @Override
    @NonNull
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return hrTransactionManager();
    }
}

