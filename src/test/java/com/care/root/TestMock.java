package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	@Autowired 
	MemberController mc;	
	MockMvc mock;
	
	
	@org.junit.Before
	public void setUp() {
		System.out.println("test 실행 전 ------------");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		System.out.println("-----testindex 실행");
		mock.perform(get("/index"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/index"));
	}
	
	//데이터 삽입 테스트
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform(post("/insert").param("id", "5555").param("name", "연습1234"))
		.andDo(print())
		//리다이렉트는 302를 돌려준다. 302면 다른위치로 이동
		.andExpect(status().is3xxRedirection());
	}
	
	//데이터 출력 및 모델 값 확인 테스트
	@Test
	public void testMemberView() throws Exception {
		mock.perform(get("/memberview")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));
	}
}
