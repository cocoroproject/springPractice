package kosta.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory2 {

	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter(){
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter(){
		return new MemberInfoPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc(){
		return new MemberRegisterService();
	}
}
