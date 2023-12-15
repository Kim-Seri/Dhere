package com.springstudy.dhere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.MemberDao;
import com.springstudy.dhere.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//로그인 프로세스
	@Override
	public int login(String email,String pass) {
		
		int result=-1;
		Member m=memberDao.getMember(email);
		System.out.println(email);
		System.out.println(pass);
		System.out.println(m.getEmail());
		System.out.println(m.getPass());
		
		//회원이 없을 때
		if(m==null) {
			return result;
		}

		if(passwordEncoder.matches(pass, m.getPass())) { //로그인 성공 했을 때
			result=1;
		}else { //로그인 실패 했을 때
			result=0;
		}
		
		return result;
	}
	
	//회원 정보 가져오
	@Override
	public Member getMember (String email) {
		return memberDao.getMember(email);
	}
	
}
