package kosta.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		/*		
		// 설정파일이 어디있는지 저장해주는 객체
		Resource resource = new ClassPathResource("applicationContext.xml");
	    // 객체를 생성해주는 factory 객체
		BeanFactory factory = new XmlBeanFactory(resource);
		// 설정파일에 설정한 bean 태그에 id/name 을 통해 객체를 받아온다.
		Service service = (Service)factory.getBean("service");
		service.insert();*/
		
		
		/*오토와이어 쓸때는 윗부분 주석후 이거 써야함*/
	//	ApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");  
		
	//	Service service = (Service)factory.getBean("service");
	//	service.insert();
	 
		// Factory 라는 자바클래스가 xml 역할을 한다.
/*		ApplicationContext ctx = new AnnotationConfigApplicationContext(Factory.class);
		
		Service service = (Service)ctx.getBean("writeService");
		service.insert();*/
		
		String[] config = {
			"applicationContext.xml",
			"commonConcern.xml"
		};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
/*		Service service = (Service)context.getBean("service");
		service.insert();
*/		
		Kosta kosta = (Kosta)context.getBean("kosta");
		kosta.insert();
	}
		

}
