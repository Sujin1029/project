package namoo.springjpa.repository.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import namoo.springjpa.entity.user.User;

public interface UserRepository {
	
	/** 회원 등록 */
	public void create(User user);
	
	/** 회원 아이디로 회원 조회 */
	public User findById(String id);
	
	/** 회원 전체 목록 조회 */
	public  List<User> findAll();
	
	/** 회원 정보 수정 */
	public void update(User user);
	
	/** 회원이름으로 검색 */
	public List<User> findByName(String name);
	
	/** 성으로 검색 */
	public List<User> findByLastName(String lastName);

	
	/** 회원 검색 */
	//public  List<User> findByOption(Map<String, String> searchMap);

}
