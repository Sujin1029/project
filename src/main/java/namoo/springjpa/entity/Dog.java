package namoo.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
	private String name;
	private int age;
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(0);
		dog.setName("루니");
		System.out.println(dog.toString());
	}
}
