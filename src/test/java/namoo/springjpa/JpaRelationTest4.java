package namoo.springjpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.Locker;
import namoo.springjpa.entity.user.Member;
import namoo.springjpa.repository.user.JpaLockerRepository;
import namoo.springjpa.repository.user.JpaMemberRepository;

@SpringBootTest
@Slf4j
public class JpaRelationTest4 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaLockerRepository lockerRepository;

	//  JPA 1:1 단방향 연관관계 매핑 완성
	@Test
	public void jpaInsert() {
		Locker locker = new Locker();
		locker.setName("락커1");
		lockerRepository.save(locker);

		Member member = new Member();
		member.setName("함수진");
		member.setAge(27);
		member.setLocker(locker);
		memberRepository.save(member);
		log.info("회원과 락커 저장 완료.");
	}

	@Test
	@Transactional
	public void jpaRead() {
		Optional<Locker> optional = lockerRepository.findById(3L);
		Locker locker = optional.get();
		String lockerName = locker.getName();
		Member lockerOwner = locker.getMember();
		log.info("락커명 : {}",  lockerName);
		log.info("락커주인 : {}",lockerOwner.getName());
	}
}
