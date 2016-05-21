package kosta.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class JNDIObject {
	private static final String name = "java:comp/env/jdbc/oracle";
	Object objectToBind;
	
	public JNDIObject(){
		objectToBind = createSource();
	}

	public Object createSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@172.16.85.160:1521:XE");
		dataSource.setUsername("kosta111");
		dataSource.setPassword("1234");
		
		return dataSource;
	}

	public Object getObjectToBind() {
		return objectToBind;
	}

	public void setObjectToBind(Object objectToBind) {
		this.objectToBind = objectToBind;
	}
	
	public void jndiBind(){
		Object objectToBind = new JNDIObject().getObjectToBind();
		
		try{
			SimpleNamingContextBuilder.emptyActivatedContextBuilder().bind(name, objectToBind);
		}catch(Exception e){}
	}
	
	
}













