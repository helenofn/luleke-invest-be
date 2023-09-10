package br.com.luleke.investbe.model.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.luleke.investbe.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select user "
			+ "from User user "
			+ "join fetch user.status "
			+ "join fetch user.roles "
			+ "where user.email = :email ")
	public Optional<User> findByEmail(String email);
}
