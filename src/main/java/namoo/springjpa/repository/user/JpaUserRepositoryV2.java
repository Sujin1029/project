package namoo.springjpa.repository.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;

@Slf4j
@Repository
@Transactional
public class JpaUserRepositoryV2 implements UserRepository {
	
	@Autowired
	private SpringDataJpaUserRepository jpaUserRepository;

	@Override
	public void create(User user) {
		jpaUserRepository.save(user);
	}

	@Override
	public User findById(String id) {
		Optional<User> optional = jpaUserRepository.findById(id);
		if(!optional.isPresent()) {
			throw new RuntimeException(id+"에 해당하는 회원이 존재하지 않습니다.");
		}
		return optional.get();
	}

	@Override
	public List<User> findAll() {
		return jpaUserRepository.findAll();
	}

	@Override
	public void update(User user) {
		User findUser = findById(user.getId());
		if(user.getPasswd() != null)  findUser.setPasswd(user.getPasswd());
		if(user.getEmail() != null)   findUser.setEmail(user.getEmail());
		
	}

	@Override
	public List<User> findByName(String name) {
		return jpaUserRepository.findAllByNameLike(name);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		return jpaUserRepository.findAllByNameStartingWith(lastName);
	}
	
	

}
