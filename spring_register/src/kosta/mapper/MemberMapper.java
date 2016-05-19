package kosta.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kosta.model.AuthInfo;
import kosta.model.LoginCommand;
import kosta.model.Member;

public interface MemberMapper {
	void insertMember(Member m);
	Member selectByEmail(String email);
	List<Member> selectByRegdate(Map<String, Date> map);
	int loginCheck(LoginCommand command);
	AuthInfo getAuthInfo(String email);
	void updateMember(Member m);
}
