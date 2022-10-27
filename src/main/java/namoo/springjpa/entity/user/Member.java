package namoo.springjpa.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
	name = "member_seq_gen",     // 시퀀스 생성 이름
	sequenceName = "member_seq", // DB 시퀀스 이름
	initialValue = 1,            // 시작값
	allocationSize = 1)          // JPA에서 가상으로 관리할 시퀀스 할당 범위(기본값은 50이며, 1로 설정하는 경우 매번 insert시마다 DB의 시퀀스 사용)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
	private Long id;
//	@Column(name = "team_id")
//	private Long teamId;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	@OneToOne	// 1:1 관계 단방향
	@JoinColumn(name="locker_id")
	private Locker locker;
	
	private String name;
	private int age;
}








