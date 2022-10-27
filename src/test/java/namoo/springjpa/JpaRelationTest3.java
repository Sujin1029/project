package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
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
public class JpaRelationTest3 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	//  JPA 양방향 연관관계 매핑 완성
	@Test
	@Disabled
	public void jpaInsert() {
		// Team 생성 및 저장
		Team Team = new Team();
		Team.setName("TeamA");
		teamRepository.save(Team);

		// Member 생성 및 저장
		Member Member1 = new Member();
		Member1.setName("채형원");
		Member1.setAge(30);
		Member1.setTeam(Team);
		Team.getMembers().add(Member1);
		memberRepository.save(Member1);

		Member Member2 = new Member();
		Member2.setName("이민혁");
		Member2.setAge(30);
		Member2.setTeam(Team);
		Team.getMembers().add(Member2);
		memberRepository.save(Member2);

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
