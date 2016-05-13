package kosta.spring;

public class ChangePasswordService {
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) throws Exception{
		Member member = dao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newPwd);
		dao.update(member);
	}
}









