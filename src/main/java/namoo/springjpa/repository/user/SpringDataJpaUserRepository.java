package namoo.springjpa.repository.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.User;

public interface SpringDataJpaUserRepository extends JpaRepository<User, String> {
	
	// 필요한 메소드 추가..	
	// Query Method 활용
	public List<User> findAllByNameLike(String name);
	public List<User> findAllByNameStartingWith(String lastName);
	
	public List<User> findAllByNameContaining(String name);
	// 날짜에 의한 검색
	List<User> findAllByRegdateGreaterThanEqual(Date regdate);

	// JPQL 직접 사용
	//@Query("select u from User u where u.regdate >= :regdate")
	//List<User> findAllByRegdateGreaterThanEqual(@Param("regdate") Date regdate);

	// 날짜 범위에 의한 검색
	List<User> findAllByRegdateBetween(Date startRegdate, Date endRegdate);
	
	// 로그인 검색
	User findByIdAndPasswd(String id, String passwd);
	
	// 정렬
	List<User> findAllByNameContaining(String name, Sort sort);
	
	Page<User> findAllByIdContainingOrEmailContaining(String id, String email, Pageable pageable );



}
