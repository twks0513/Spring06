package com.care.root;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class) //Test구동을 어떤것으로 할것인가
@ContextConfiguration(locations = {"classpath:testMember.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMember {
	@Autowired
	MemberController mc;
	@Test
	public void testMc() {
		System.out.println("----mc : "+mc);
		assertNotNull(mc); //객체가 null이 아니면 성공으로 뜨게한다
	}
	@Autowired
	MemberService ms;
	@Test
	public void testMs() {
		System.out.println("----ms : "+ms);
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(1234);
		dto.setName("홍길동");
		
		ms.insert(dto);
	}
	@Autowired
	MemberDAO dao;
	@Test
	public void testDao() {
		System.out.println("----dao : "+dao);
		assertNotNull(dao);
		MemberDTO dto = new MemberDTO();
		dto.setId(1111);
		dto.setName("홍길동");
		
		dao.insert(dto);
	}
	
	
	
	
}
