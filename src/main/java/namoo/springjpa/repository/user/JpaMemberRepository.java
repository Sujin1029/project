package namoo.springjpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

}
