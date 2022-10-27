package namoo.springjpa.repository.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;

@Slf4j
//@Repository
// JPA의 모든 데이터 변경(등록, 수정, 삭제)은 트랜잭션 안에서 이루어져야 한다.
// JPA에서는 데이터 변경시 트랜잭션이 필수다.
// 일반적으로는 비즈니스 로직을 시작하는 서비스 계층에서 트랜잭션을 걸어준다.
@Transactional
public class JpaUserRepository implements UserRepository {
	
	// 스프링 부트와 통합되어 복잡한 설정(DataSource 설정 등) 없이 주입 받을 수 있다.
	// JPA의 모든 동작은 EntityManager를 통해서 이루어진다.
	// EntityManager는 내부에 DataSource를 가지고 있고, 커넥션풀을 통해 데이터베이스에 접근한다.
	@Autowired
	private EntityManager entityManager;


	@Override
	public void create(User user) {
		// SQL 동적 생성 인서트문 실행 완료!
		entityManager.persist(user);
	}

	@Override
	public User findById(String id) {
		// JPA에서 엔티티 객체를 PK를 기준으로 조회할 때는 find() 를 사용하고 조회 타입과, PK 값을 전달한다 
		// JPA가 SELECT SQL을 만들어서 실행하고, 결과를 객체로 반환한다
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		// JPA는 JPQL(Java Persistence Query Language)이라는 SQL 문법과 비슷한 객체지향 쿼리 언어를 제공한다
		// 주로 여러 데이터를 복잡한 조건으로 조회할 때 사용한다
		// SQL이 테이블을 대상으로 한다면, JPQL은 엔티티 객체를 대상으로 SQL을 실행한다
		// 엔티티 객체를 대상으로 하기 때문에 from 다음에 User 엔티티 객체 이름이 들어간다
		// 엔티티 객체와 속성의 대소문자는 구분해야 한다
		// JPQL을 실행하면 그 안에 포함된 엔티티 객체의 매핑 정보를 활용해서 SQL을 작성한다
		String jpql = "select u from User u";
		List<User> result = entityManager.createQuery(jpql, User.class).getResultList();
		return result;
	}

	@Override
	public void update(User user) {
		// 마치 자바 콜렉션에 조회한 걸 수정하는 것처럼 실행
		User findUser = entityManager.find(User.class, user.getId());
		String passwd = user.getPasswd();
		String email = user.getEmail();
		if(passwd != null) findUser.setPasswd(passwd);
		if(email != null) findUser.setEmail(email);
		// JPA는 트랜잭션이 커밋되는 시점에, 변경된 엔티티 객체가 있는지 확인한 후 
		// 엔티티 객체가 변경된 경우 UPDATE SQL 작성하여 실행한다
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
