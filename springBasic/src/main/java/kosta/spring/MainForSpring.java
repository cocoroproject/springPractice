package kosta.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args)throws IOException {
		ctx = new GenericXmlApplicationContext("appCtx.xml");
		
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));

		while(true){
			System.out.println("명령문을 입력하세요.");
			String command = reader.readLine();
			if(command.equals("exit")){
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new ")){
				processNewCommand(command.split(" "));
				continue;
			}else if(command.equals("list")){
				processListCommand();
				continue;
			}else if(command.startsWith("change ")){
				processChagneCommand(command.split(" "));
			}
			printHelp();
			
		}
	}//end main
	
	private static void processChagneCommand(String[] arg){
		if(arg.length != 4){
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc =
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("수정완료 되었습니다.");
		} catch (Exception e) {
			System.out.println("존재하지 않는 이메일 또는 암호가 일치 하지 않습니다.");
		}
	}
	
	
	private static void processListCommand(){
		MemberListPrinter listPrinter =
				ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processNewCommand(String[] arg){
		if(arg.length != 5){
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(arg[1]);
		request.setName(arg[2]);
		request.setPassword(arg[3]);
		request.setConfirmPassword(arg[4]);
		
		if(!request.isPasswordEqual()){
			System.out.println("암호가 서로 일치하지 않습니다.");
			return;
		}
		
		try {
			regSvc.regist(request);
			System.out.println("등록했습니다.");
		} catch (Exception e) {
			System.out.println("이미 존재하는 이메일 입니다.");
		}
		
		
	}
	
	private static void printHelp(){
		System.out.println("잘못된 명령어 입니다.");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");		
	}

}










