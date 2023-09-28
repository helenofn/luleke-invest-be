package br.com.luleke.investbe.service.rule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.AccountEmailAlreadyExistsException;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.model.respository.util.UserRepositoryTestUtil;
import jakarta.transaction.Transactional;

@Transactional
public class AccountEmailAlreadyExistsRuleTest extends AbstractLulekeInvestBeTest{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountEmailAlreadyExistsRule accountEmailAlreadyExistsRule;
	private User user;
	
	@BeforeEach
    void setup(){
		this.user = UserRepositoryTestUtil.buildUser();
		userRepository.save(this.user);
    }
	
	@DisplayName("Test to check if the \"user already exists\" rule when user with already exists e-mail")
	@Test
	void givenUserObjectWithSameEmailAnotherUser_whenSave_thenThrowAccountEmailAlreadyExistsException() {
		User userAux = UserRepositoryTestUtil.buildUser();
		assertThrows(AccountEmailAlreadyExistsException.class, () -> this.accountEmailAlreadyExistsRule.initialize(userAux.getEmail()).validate());
	}
	
	@DisplayName("Test to check if the \"user already exists\" rule when user with an e-mail that doesnt exist")
	@Test
	void givenUserObjectWithNewEmail_whenSave_thenDoesNotThrowException() {
		User userAux = UserRepositoryTestUtil.buildUser2();
		assertDoesNotThrow(() -> this.accountEmailAlreadyExistsRule.initialize(userAux.getEmail()).validate());
	}

}
