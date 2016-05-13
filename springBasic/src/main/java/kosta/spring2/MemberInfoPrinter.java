package kosta.spring2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	/*@Autowired
	@Qualifier("sysout")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}*/
		
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public MemberPrinter getPrinter() {
		return printer;
	}


	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}











