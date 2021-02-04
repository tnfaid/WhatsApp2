package blast.whatsapp.Dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;

@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DbConfig
{
    @Value("${send.pool}")
    int sendCorePoolSize;

    @Value("${fallback.pool}")
    int fallbackCorePoolSize;

    @Value("${update.pool}")
    int updateCorePoolSize;

    @Value("${pending.pool}")
    int pendingCorePoolSize;


    @Bean(name = "whatsAppDataSource")
    DataSource initWhatsAppDataSource( @Value("${spring.datasource.number}") int poolSize,
                                       @Value("${spring.datasource.username }") String username,
                                       @Value("${spring.datasource.password}") String password,
                                       @Value("${spring.datasource.url}") String url,
                                       @Value("${spring.datasource.driver-class-name}") String driverClass,
                                       @Value("${spring.datasource.leakDetectionThreshold}") int leakDetectionThreshold,
                                       @Value("${spring.datasource.connectionTimeOut}") int connectionTimeout,
                                       @Value("${spring.datasource.connectionMaxLifeTime}") int connectionMaxLifeTime )
    {
        final HikariDataSource hikariDataSource = init(poolSize, username, password, url, driverClass,
                leakDetectionThreshold, connectionMaxLifeTime, connectionTimeout);
        return hikariDataSource;
    }

    private HikariDataSource init( int poolSize, String username, String password, String url, String driverClass, int leakDetectionThreshold, int connectionMaxLifeTime, int connectionTimeout )
    {
        final HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(poolSize);
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClass);
        config.setLeakDetectionThreshold(leakDetectionThreshold * 1000);
        config.setConnectionTimeout(connectionTimeout * 1000);
        config.setMaxLifetime((connectionMaxLifeTime * 60) * 1000);

        return new HikariDataSource(config);
    }

    @Bean(name="sendPool")
    public ThreadPoolTaskExecutor sendExecutor()
    {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(sendCorePoolSize);
        pool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * sendCorePoolSize);
        pool.setQueueCapacity(300);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

    @Bean(name="pendingPool")
    public ThreadPoolTaskExecutor pendingExecutor()
    {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(pendingCorePoolSize);
        pool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * pendingCorePoolSize);
        pool.setQueueCapacity(100);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }


    @Bean(name="fallbackPooll")
    public ThreadPoolTaskExecutor fallbackExecutor()
    {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(pendingCorePoolSize);
        pool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * fallbackCorePoolSize);
        pool.setQueueCapacity(100);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

    @Bean(name="updatePooll")
    public ThreadPoolTaskExecutor updatePool()
    {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(pendingCorePoolSize);
        pool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * updateCorePoolSize);
        pool.setQueueCapacity(200);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

}
