package com.springstudy.dhere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void addMember(Member m) {
		m.setPass(passwordEncoder.encode(m.getPass()));
		System.out.println(m.getPass());
		memberDao.addMember(m);
	}
	
	//아이디 중복확인 메서드
		@Override
		public boolean overEmailCheck(String id) {
			boolean result=false;
			Member m=memberDao.getMember(id);
			if(m==null) {
				result=true;
			}
			return result;
		}

}
