package kosta.spring2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId=0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email){
		return map.get(email);
	}
	
	public void insert(Member member){
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		System.out.println("입력성공");
	}
	
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	public void update(Member member){
		map.put(member.getEmail(), member);
	}
	
}











