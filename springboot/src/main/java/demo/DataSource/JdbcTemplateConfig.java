package demo.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


@Configuration

public class JdbcTemplateConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateConfig.class);

    @Qualifier("ecologyDataSource")
    private final DataSource ecologyDataSource;

    @Qualifier("hrDataSource")
    private final DataSource hrDataSource;

    public JdbcTemplateConfig(DataSource ecologyDataSource, DataSource hrDataSource) {
        this.ecologyDataSource = ecologyDataSource;
        this.hrDataSource = hrDataSource;
    }

    @Bean(name = "ecologyJdbcTemplate")
    public JdbcTemplate ecologyJdbcTemplate() {
        return new JdbcTemplate(ecologyDataSource);
    }

    @Bean(name = "hrJdbcTemplate")
    public JdbcTemplate hrJdbcTemplate() {

        try {
            LOGGER.info("HR DataSource URL: {}", hrDataSource.getConnection().getMetaData().getURL());
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }

        return new JdbcTemplate(hrDataSource);
    }
}
