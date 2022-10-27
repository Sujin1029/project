package namoo.springjpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.Member;
import namoo.springjpa.entity.user.Team;
import namoo.springjpa.repository.user.JpaMemberRepository;
import namoo.springjpa.repository.user.JpaTeamRepository;

@SpringBootTest
@Slf4j
public class JpaRelationTest {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;
	
	// 단방향 조회 테스트
	@Test
	public void jpaTest() {
		// Team 생성 및 저장
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);

		// Member 생성 및 저장
		Member insertMember = new Member();
		insertMember.setName("홍길동");
		insertMember.setAge(10);
//		insertMember.setTeamId(insertTeam.getId());
		insertMember.setTeam(insertTeam);
		memberRepository.save(insertMember);
		log.info("테이블 생성 및 저장 완료!");

		// 조회 시 2번 조회해야 한다.
		Optional<Member> optional = memberRepository.findById(insertMember.getId());
		if (optional.isPresent()) {
			Member findMember = optional.get();
			log.info("회원이름 : {}, 팀이름: {}", findMember.getName(), findMember.getTeam().getName());
		}
	}
}






