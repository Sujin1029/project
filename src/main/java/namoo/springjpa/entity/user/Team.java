package namoo.springjpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
	name = "team_seq_gen", 
	sequenceName = "team_seq", 
	initialValue = 1,    
	allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")// mappedBy : members에 등록되어 있는 Member의 team 속성에 매핑되었음을 의미
	// 연관관계의 주인(Owner)이 Member의 team 임을 설정
	// @JoinColumn 설정하지 않는다
	private List<Member> members = new ArrayList<Member>();	// 얘가 가지고 있는 member는 오로지 참조만 가능

}
