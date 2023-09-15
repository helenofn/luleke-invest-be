package br.com.luleke.investbe.model.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.luleke.investbe.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select user "
			+ "from User user "
			+ "left join fetch user.status "
			+ "left join fetch user.roles "
			+ "where user.id = :userId ")
	public Optional<User> findById(Long userId);
	
	@Query("select user "
			+ "from User user "
			+ "left join fetch user.status "
			+ "left join fetch user.roles as role "
			+ "where UPPER(user.email) = UPPER(:email) ")
	public Optional<User> findByEmail(String email);
}
