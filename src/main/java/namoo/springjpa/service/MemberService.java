package namoo.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.UserRepository;

@Service	// 스프링 컨테이너 서비스 선언
@Slf4j
public class MemberService {
	
	@Autowired
	UserRepository userRepository;
	
	public void biz1() {
		log.info("biz1() 메소드 실행됨");
		List<User> list = userRepository.findAll();
		log.info("회원수 : {}", list.size());
	}
	public void biz2() {
		log.info("biz2() 메소드 실행됨");
	}

}
