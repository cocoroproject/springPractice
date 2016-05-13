package kosta.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args)throws Exception {
//		ApplicationContext ctx =
//				new GenericXmlApplicationContext("appCtx2.xml");
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Factory2.class);
		
		
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail("aa@aa.com");
		req.setName("홍길동");
		req.setPassword("1234");
		req.setConfirmPassword("1234");
		
		regSvc.regist(req);
		
		infoPrinter.printMemberInfo("aa@aa.com");
	}

}










