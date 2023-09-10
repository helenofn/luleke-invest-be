package br.com.luleke.investbe.model.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luleke.investbe.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmail(String email);
}
