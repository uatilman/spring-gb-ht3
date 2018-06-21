package ru.tilman.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.tilman.repository")
@ComponentScan({"ru.tilman.repository"})
@PropertySource("classpath:database-configuration.properties")
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource(
            @Value("${datasource.url}") String dataSourceUrl,
            @Value("${datasource.user}") String dataSourceUserName,
            @Value("${datasource.password}") String dataSourcePassword,
            @Value("${datasource.driver}") String dataSourceDriverClassName
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceUrl);
        dataSource.setDriverClassName(dataSourceDriverClassName);
        dataSource.setUsername(dataSourceUserName);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            @Qualifier("dataSource") DataSource dataSource,

            @Value("${hibernate.dialect}") String dialect,
            @Value("${hibernate.max_fetch_depth}") int maxFetchDepth,
            @Value("${hibernate.jdbc.fetch_size}") int fetchSize,
            @Value("${hibernate.jdbc.batch_size}") int batchSize,
            @Value("${hibernate.show_sql}") boolean showSql,
            @Value("${hibernate.hbm2ddl.auto}") String tableStrategy

    ) {

        final Properties properties = new Properties(); // Создание свойств для настройки Hibernate
        properties.put("hibernate.dialect", dialect); // Указание диалекта конкретной базы данных – необходимо для генерации запросов Hibernate к БД
        properties.put("hibernate.max_fetch_depth", maxFetchDepth); // Указание максимальной глубины связи (будет рассмотрено в следующем уроке)
        properties.put("hibernate.jdbc.fetch_size", fetchSize); // Определение максимального количества строк, возвращаемых за один запрос из БД
        properties.put("hibernate.jdbc.batch_size", batchSize); // Определение максимального количества запросов при использовании пакетных операций
        properties.put("hibernate.show_sql", showSql); // Включает логирование
        properties.put("hibernate.hbm2ddl.auto", tableStrategy); //properties.put("hibernate.hbm2ddl.auto", "update");

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean(); // Создание класса фабрики, реализующей интерфейс FactoryBean<EntityManagerFactory>
        factory.setDataSource(dataSource); // Задание источника подключения
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // Задание адаптера для конкретной реализации JPA. Указывает, какая именно библиотека будет использоваться в качестве поставщика постоянства
        factory.setPackagesToScan("ru.tilman.entity"); // Указание пакетов, в которых будут находиться классы-сущности
        factory.setPersistenceUnitName("persistenceUnit");
        factory.setJpaProperties(properties);

        return factory;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
    ) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }

}
