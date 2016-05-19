package kosta.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
public class SessionAspect {

	
	
	@Around("execution(public * *exe(..))")   // execution으로 AOP 대상 설정 -> exe로 끝나는 메소드가 실행되기 전에 세션체크를 할 수있도록.
	public String sessionCheck(ProceedingJoinPoint jointPoint)throws Throwable{   // 세션체크가 비니지스가 실행되기 전후에 되야 한다.
																				// Around 의 경우 파라미터로 ProceedingJoinPoint가 와야함
		Object[] args = jointPoint.getArgs();      // ProceedingJoinPoint를 파라미터로 하면 session 객체를 오브젝트배열로 가져올수있음.
		HttpSession session = (HttpSession)args[0];
		
		String name = (String)session.getAttribute("name");
		String view_name = "/session/fail.jsp";
		
		try {
			if(name == null)   // 세션값을 가지고 있지 않는 경우
			{
				throw new Exception("no session");   // 세션이 없으면 catch에서 예외처리
			}
			
			view_name = (String)jointPoint.proceed();   // 세션을 가진 경우 session_exe 메소드 호출
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return view_name;
	}
}
