package namoo.springjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.service.MemberService;

@SpringBootTest
@Slf4j
public class SpringAopTest {
	
	@Autowired
	MemberService service;
	// TimeTraceAspect 가 실행됨
	@Test
	public void aopTest() {
		service.biz1();
		service.biz2();
	}
}
