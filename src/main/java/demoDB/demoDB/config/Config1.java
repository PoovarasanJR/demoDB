package demoDB.demoDB.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config1 {

    @Bean
    public RestTemplate restTemplate() {
        // Customize the RestTemplate as needed
        return new RestTemplate();
    }

}
