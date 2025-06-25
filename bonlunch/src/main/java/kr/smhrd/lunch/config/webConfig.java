package kr.smhrd.lunch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig {

	


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/lunch/api/**").allowedOrigins("http://3.35.176.191:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
			}
		};
	}
	
	
	
	
	
	
	
}
