package kosta.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterCommand command)throws Exception{
		
		Member m = memberDao.selectByEmail(command.getEmail());
		
		if(m != null){
			throw new Exception("중복된 이메일");
		}
		
		Member member = new Member(0L,
				command.getEmail(), command.getPassword(),
				command.getName(), new Date());
		
		memberDao.insert(member);
		
	}
	
	
	public List<Member> selectByRegdate(Date from, Date to){
		Map<String, Date> map = new HashMap<String, Date>();
		map.put("from", from);
		map.put("to", to);
		
		return memberDao.selectByRegdate(map);
	}
	
	public int loginCheck(LoginCommand command){		
		return memberDao.loginCheck(command);
	}

	public AuthInfo getAuthInfo(String email) {
		return memberDao.getAuthInfo(email);
	}
}
















