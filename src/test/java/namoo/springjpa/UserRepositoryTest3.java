package namoo.springjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.SpringDataJpaUserRepository;

@SpringBootTest
@Transactional
@Slf4j
class UserRepositoryTest3 {
	
	@Autowired
	SpringDataJpaUserRepository jpaRepository;
	
	@Test
	@Disabled
	public void findAllByNameContaining() {
		String name = "기정";
		List<User> searchList = jpaRepository.findAllByNameContaining(name);
		for (User user : searchList) {
			log.info("검색된 회원 정보 : {}", user);
		}
	}
	
	@Test
	@Disabled
	public void findAllByOption() {
		String searchType = "name";
		String searchValue = "기정";
		switch (searchType) {
			case "id":
				Optional<User> optional = jpaRepository.findById(searchValue);
				if(optional.isPresent()) {
					User findUser = optional.get();
					log.info("조회된 회원 정보: {}", findUser);
				}else {
					log.info("조회된 정보가 없습니다..");
				}
				break;
			case "name":
				List<User> list = jpaRepository.findAllByNameContaining(searchValue);
				log.info("검색된 회원 목록 :  {}", list);
				break;
			default:
				List<User> list2 = jpaRepository.findAll();
				log.info("검색된 전체 회원 목록 :  {}", list2);
				break;
		}
		
		String name = "기정";
		List<User> searchList = jpaRepository.findAllByNameContaining(name);
		for (User user : searchList) {
			log.info("검색된 회원 정보 : {}", user);
		}
	}
	
	@Test
	@Disabled
	public void findAllByRegdateGreaterThanEqual() throws ParseException {
		String regdate = "22/10/10";
		Date searchRegdate = new SimpleDateFormat("yy/MM/dd").parse(regdate);
		List<User> list = jpaRepository.findAllByRegdateGreaterThanEqual(searchRegdate);
		log.info("날짜 검색 :{}, {}", list.size(), list);
	}

	@Test
	@Disabled
	public void findAllByRegdateBetween() throws ParseException {
		Date startDate = new SimpleDateFormat("yy/MM/dd").parse("22/10/13");
		Date endDate = new SimpleDateFormat("yy/MM/dd").parse("22/10/14");
		List<User> list = jpaRepository.findAllByRegdateBetween(startDate, endDate);
		log.info("날짜범위 검색 :{}, {}", list.size(), list);
	}
	
	@Test
	@Disabled
	public void login() {
		String id= "bangry";
		String passwd= "3333";
		User user = jpaRepository.findByIdAndPasswd(id, passwd);
		log.info("로그인 정보 : {}", user);
	}
	
	@Test
	public void findAllByNameContaining2() {
		//List<User> list = jpaRepository.findAll(Sort.by("name"));
		//List<User> list = jpaRepository.findAllByNameContaining("기정", Sort.by("name"));
		//List<User> list = jpaRepository.findAllByNameContaining("기정", Sort.by("name").descending());
		List<User> list = jpaRepository.findAllByNameContaining("기정", Sort.by("id").descending()
				                                                            .and(Sort.by("email")));
		for (User user : list) {
			log.info("정렬 검색 :{}", user);
		}
	}
	
	@Test
	@Disabled
	public void findAllPaging() {
		//Pageable pageable = PageRequest.of(1, 5); //요청페이지: 2, 페이지당 5개
		Sort sort = Sort.by("name").ascending();
		Pageable pageable = PageRequest.of(1, 5, sort); //요청페이지: 2, 페이지당 5개, 이름으로 정렬
		Page<User> pageResults = jpaRepository.findAll(pageable);
		log.info("목록: {}" , pageResults.getContent());
		log.info("전체목록 개수: {}" , pageResults.getTotalElements());
		log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements());
		log.info("전체페이지 개수: {}" , pageResults.getTotalPages());
		log.info("페이지당 목록 개수 {}: " , pageResults.getSize());
		log.info("현재 페이지 {}: " , pageResults.getNumber());
		log.info("처음으로 존재여부 {}: " , pageResults.isFirst());
		log.info("이전페이지 존재여부 {}: " , pageResults.hasPrevious());
		log.info("다음페이지 존재여부 {}: " , pageResults.hasNext());
		log.info("마지막으로 존재여부 {}: " , pageResults.isLast());
	}
	
	@Test
	public void findAllByIdContainingOrEmailContaining() {
		String searchValue = "n";
		Pageable pageable = PageRequest.of(0, 2);
		Page<User> pageResults = jpaRepository.findAllByIdContainingOrEmailContaining(searchValue, searchValue, pageable);
		List<User> list =  pageResults.getContent();
		
		log.info("목록: {}" , list);
		log.info("전체목록 개수: {}" , pageResults.getTotalElements());
		log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements());
		log.info("전체 페이수: {}" , pageResults.getTotalPages());
	}



}


















