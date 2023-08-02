package demoDB.demoDB.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"demoDB.demoDB.repository2"} ,
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2")
public class Config3 {
    
	@Value("${spring.datasource.second.url}")
    private String dataSource2Url;

    @Value("${spring.datasource.second.username}")
    private String dataSource2Username;

    @Value("${spring.datasource.second.password}")
    private String dataSource2Password;
    
    @Value("${spring.datasource.second.driverClassName}")
    private String dataSource2DriverClassName;
    
    @Primary
    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSource2DriverClassName);
        dataSource.setUrl(dataSource2Url);
        dataSource.setUsername(dataSource2Username);
        dataSource.setPassword(dataSource2Password);
        return dataSource;
    }
    
    @Primary
    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    	LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
    	bean.setDataSource(dataSource2());
    	JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
    	bean.setJpaVendorAdapter(adapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        bean.setJpaPropertyMap(properties);
        bean.setPackagesToScan("demoDB.demoDB.bean2");
        
        return bean;
    }
    
    @Primary
    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
    
}