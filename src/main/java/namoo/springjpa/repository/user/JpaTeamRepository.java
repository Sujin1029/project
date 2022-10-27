package namoo.springjpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.Member;
import namoo.springjpa.entity.user.Team;

public interface JpaTeamRepository extends JpaRepository<Team, Long> {

}
