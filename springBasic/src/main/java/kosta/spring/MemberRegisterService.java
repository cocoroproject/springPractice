package kosta.spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest reg)throws Exception{
		Member member = memberDao.selectByEmail(reg.getEmail());
		
		if(member != null){
			throw new Exception("중복된 아이디가 존재합니다.");
		}
		
		Member newMember = new Member(
				reg.getEmail(), reg.getPassword(), reg.getName(), new Date());
		
		memberDao.insert(newMember);
	
				
	}
}












