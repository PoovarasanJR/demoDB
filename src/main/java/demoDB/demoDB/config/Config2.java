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
        basePackages = {"demoDB.demoDB.repository1"} ,
        entityManagerFactoryRef = "entityManagerFactory1",
        transactionManagerRef = "transactionManager1")
public class Config2 {
    
	@Value("${spring.datasource.first.url}")
    private String dataSource1Url;

    @Value("${spring.datasource.first.username}")
    private String dataSource1Username;

    @Value("${spring.datasource.first.password}")
    private String dataSource1Password;
    
    @Value("${spring.datasource.first.driverClassName}")
    private String dataSource1DriverClassName;
    
    @Primary
    @Bean(name = "dataSource1")
    public DataSource dataSource1() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSource1DriverClassName);
        dataSource.setUrl(dataSource1Url);
        dataSource.setUsername(dataSource1Username);
        dataSource.setPassword(dataSource1Password);
        return dataSource;
    }
    
    @Primary
    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    	LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
    	bean.setDataSource(dataSource1());
    	JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
    	bean.setJpaVendorAdapter(adapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        bean.setJpaPropertyMap(properties);
        bean.setPackagesToScan("demoDB.demoDB.bean1");
        
        return bean;
    }
    
    @Primary
    @Bean(name = "transactionManager1")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
    
}