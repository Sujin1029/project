package namoo.springjpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.Locker;

public interface JpaLockerRepository extends JpaRepository<Locker, Long> {

}
