package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.Member;
import namoo.springjpa.entity.user.Team;
import namoo.springjpa.repository.user.JpaMemberRepository;
import namoo.springjpa.repository.user.JpaTeamRepository;

@SpringBootTest
@Slf4j
public class JpaRelationTest2 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	// 양방향 조회 테스트
	// insert TEST
	@Test
	public void jpaInsert() {
		// Team 생성 및 저장
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);

		// Member 생성 및 저장
		Member insertMember1 = new Member();
		insertMember1.setName("홍길동");
		insertMember1.setAge(10);
		insertMember1.setTeam(insertTeam);

		Member insertMember2 = new Member();
		insertMember2.setName("김길동");
		insertMember2.setAge(20);
		insertMember2.setTeam(insertTeam);

		memberRepository.save(insertMember1);
		memberRepository.save(insertMember2);

		List<Member> list = insertTeam.getMembers();
		log.info("사이즈 : {}", list.size());
		for (Member member : list) {
			log.info("등록회원 : {}", member.toString());
		}
	}

	@Test
	@Transactional
	public void readTest() {
		Optional<Team> optional = teamRepository.findById(21L);
		Team team = optional.get();
		log.info("팀명 : {}", team.getName());
		log.info("회원 목록");
		List<Member> list = team.getMembers();
		for (Member member : list) {
			log.info("회원명: {}", member.getName());
		}
	}
}
