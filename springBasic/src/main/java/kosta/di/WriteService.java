package kosta.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WriteService implements Service {
     private Dao dao;
     
     public WriteService(){}
     
     public WriteService(Dao dao){
    	 this.dao = dao;
     }
    
     
	@Autowired
	@Qualifier("oracle")
	public void setDao(Dao dao){
		this.dao = dao;
   	 
    }
	
	@Override
	public void insert() {
		System.out.println("Write Service insert() 호출");
		dao.insertBoard();	
	}

}
