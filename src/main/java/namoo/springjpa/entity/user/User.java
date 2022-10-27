package namoo.springjpa.entity.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA가 사용하는 객체라는 의미의 에노테이션(JPA가 인식)
@Entity
//Entity 이름과 테이블 이름이 동일할 경우 생략 가능
@Table(name = "users")
//SQL 디폴트 값 자동 입력
@DynamicInsert
//Lombok 에노테이션
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
//테이블의 PK와 해당 필드 매핑
	@Id
	private String id;
//객체 필드명과 테이블 컬럼명 동일 시 생략 가능
//	@Column(name = "name")
	private String name;
	private String passwd;
	private String email;
//SQL 데이터타입 설정
//@Temporal(TemporalType.DATE)
//@Temporal(TemporalType.TIME)
//@Temporal(TemporalType.TIMESTAMP) : 디폴트
	private Date regdate;
//JPA 기본 생성자는 필수이다.
	public User(String id, String name, String passwd, String email) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
	}
	
}
