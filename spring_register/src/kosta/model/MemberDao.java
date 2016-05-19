package kosta.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mapper.MemberMapper;

@Repository
public class MemberDao {
	private SqlSessionTemplate myTemplate;
		
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public void insert(Member m){
		myTemplate.getMapper(MemberMapper.class).insertMember(m);
	}
	
	public Member selectByEmail(String email){
		return myTemplate.getMapper(MemberMapper.class).selectByEmail(email);
	}
	
	public List<Member> selectByRegdate(Map<String, Date> map){
		return myTemplate.getMapper(MemberMapper.class).selectByRegdate(map);
	}
	
	public int loginCheck(LoginCommand command){
		return myTemplate.getMapper(MemberMapper.class).loginCheck(command);
	}

	public AuthInfo getAuthInfo(String email) {
		return myTemplate.getMapper(MemberMapper.class).getAuthInfo(email);
	}

	public void update(Member member) {
		myTemplate.getMapper(MemberMapper.class).	updateMember(member);	
	}
}
















