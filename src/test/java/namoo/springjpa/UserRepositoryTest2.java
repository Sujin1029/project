package namoo.springjpa;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.UserRepository;

@SpringBootTest
@Transactional
@Slf4j
class UserRepositoryTest2 {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Disabled
	public void findAll() {
		List<User> list = userRepository.findAll();
		log.info("실행하는 객체 : {}", userRepository.getClass().getName());
		log.info("검색된 전체 회원수 : {}", list.size());
		log.info("검색된 전체 회원리스트 : {}", list);
	}
	
	@Test
	@Disabled
	public void findById() {
		User user = userRepository.findById("bangry");
		log.info("검색된 회원 정보 : {}", user);
	}
	
	@Test
//	@Commit
	@Disabled
	public void creat() {
		User user = new User();
		user.setId("biden000");
		user.setPasswd("1111");
		user.setName("날리면");
		user.setEmail("biden000@gmail.com");
		userRepository.create(user);
		log.info("추가된 회원 정보 : {}", user);
	}
	
	@Test
//	@Commit
	@Disabled
	public void update() {
		User user = new User();
		user.setId("bangry");
		user.setPasswd("3333");
		user.setEmail("updatebangry@naver.com");
		userRepository.update(user);
		log.info("변경된 회원 정보 : {}", user);
	}
	
	@Test
	@Disabled
	public void findByName() {
		String searchValue = "%기정%";
		List<User> searchList = userRepository.findByName(searchValue);
		for (User user : searchList) {
			log.info("검색된 회원 정보 : {}", user);
		}
	}
	
	@Test
	public void findByLastName() {
		String lastName = "김";
		List<User> searchList = userRepository.findByLastName(lastName);
		for (User user : searchList) {
			log.info("검색된 회원 정보 : {}", user);
		}
	}

}


















