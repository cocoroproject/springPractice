package kosta.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Factory {
	
	@Bean
	public Dao useDao(){
		return new OracleDao();
	}
	
	@Bean
	public Service writeService(){
		return new WriteService();
	}
}
