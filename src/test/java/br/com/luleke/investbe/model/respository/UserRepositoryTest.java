package br.com.luleke.investbe.model.respository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.LulekeInvestBeApplicationTests;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.respository.util.UserRepositoryTestUtil;
import jakarta.transaction.Transactional;

@Transactional
public class UserRepositoryTest extends LulekeInvestBeApplicationTests{

	@Autowired
	private UserRepository userRepository; 
	private User user;
	
	@BeforeEach
    void setup(){
		this.user = UserRepositoryTestUtil.buildUser();
    }
	
	@DisplayName("Test to save user")
	@Test
	void givenUserObject_whenSave_thenReturnSavedUser() {
		User userAux = this.userRepository.save(this.user);
		UserRepositoryTestUtil.validateUserDataReturn(userAux);
        assertThat(userAux.getId()).isGreaterThan(0);
	}
	
	@DisplayName("Test to quey user by id")
	@Test
	void givenIdFromUserSaved_whenQueyById_thenReturnUser() {
		User userAux = this.userRepository.save(this.user);
		User user = this.userRepository.findById(userAux.getId()).orElse(null);
		UserRepositoryTestUtil.validateUserDataReturn(user);
	}
	
	@DisplayName("Test to quey user by e-mail")
	@Test
	void givenEmailFromUserSaved_whenQueryByMail_thenReturnUser() {
		this.userRepository.save(this.user);
		User user = this.userRepository.findByEmail(this.user.getEmail()).orElse(null);
		UserRepositoryTestUtil.validateUserDataReturn(user);
		assertEquals(this.user.getEmail(), user.getEmail());
	}
	
	@DisplayName("Test to delete user")
	@Test
	void givenUserObject_whenDelete_thenDoesNotTrowException() {
		this.user = this.userRepository.save(this.user);
		User user = this.userRepository.findById(this.user.getId()).orElse(null);
		assertThat(user).isNotNull();
		assertDoesNotThrow(() -> this.userRepository.delete(user));
	}

}
