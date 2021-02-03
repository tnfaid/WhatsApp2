package blast.whatsapp.Dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DbConfig
{
    @Bean(name = "whatsAppDataSource")
    DataSource initWhatsAppDataSource( @Value("${spring.datasource.number}") int poolSize,
                                       @Value("${spring.datasource.username }") String username,
                                       @Value("${spring.datasource.password}") String password,
                                       @Value("${spring.datasource.url}") String url,
                                       @Value("${}")

                                       )
}
