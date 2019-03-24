package io.javabrains.moviecatalogservice;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {

    @Bean
	public RestTemplate getRestTemplate(){
    	return new RestTemplate();
	}
	@Bean
	public DiscoveryClient getDiscoveryClient(){
    	return new DiscoveryClient();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
