package br.com.luleke.investbe.rule.group;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.AccountEmailAlreadyExistsException;
import br.com.luleke.investbe.exception.InvalidEmailException;
import br.com.luleke.investbe.exception.InvalidUserNameException;
import br.com.luleke.investbe.exception.InvalidUserPassException;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.test.util.UserTestUtil;

@Transactional
public class SignupUserRuleGroupTest extends AbstractLulekeInvestBeTest{

	@Autowired
	private SignupUserRuleGroup signupUserRuleGroup;
	@Autowired
	private UserRepository userRepository;
	
	@DisplayName("Check if a user with invalid mail throws InvalidEmailException")
	@Test
	void givenUserWithInvalidMail_whenValidate_thenThrowsInvalidEmailException() {
		User user1 = UserTestUtil.buildUserMail("");
		User user2 = UserTestUtil.buildUserMail(null);
		User user3 = UserTestUtil.buildUserMail("asasa@");
		User user4 = UserTestUtil.buildUserMail(".com");
		User user5 = UserTestUtil.buildUserMail("sasa@sasa.");
		User user6 = UserTestUtil.buildUserMail("asaasasasaasaasasasaasaasasasaasaasasasaasaasasasaasaasasasasasasasasasasaasasasasasasasasasadsasasasasadfdfdsfsdfdsasasaddfdfdsfsdfdsfdsfsffs@sdaasdsdsa.com");
		
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user1));
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user2));
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user3));
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user4));
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user5));
		assertThrows(InvalidEmailException.class, () -> this.signupUserRuleGroup.validateRules(user6));
	}
	
	@DisplayName("Test to check if the \"user already exists\" rule when user with already exists e-mail")
	@Test
	void givenUserObjectWithSameEmailAnotherUser_whenSave_thenThrowAccountEmailAlreadyExistsException() {
		User user = UserTestUtil.buildUser();
		User userAux = UserTestUtil.buildUser();
		userRepository.save(user);
		assertThrows(AccountEmailAlreadyExistsException.class, () -> this.signupUserRuleGroup.validateRules(userAux));
	}
	
	@DisplayName("Check if user with invalid name throws InvalidUserNameException")
	@Test
	void givenUserWithInvalidUserName_whenValidate_thenThrowsInvalidUserNameException() {
		User user1 = UserTestUtil.buildUserName("aaaa");
		User user2 = UserTestUtil.buildUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertThrows(InvalidUserNameException.class, () -> this.signupUserRuleGroup.validateRules(user1));
		assertThrows(InvalidUserNameException.class, () -> this.signupUserRuleGroup.validateRules(user2));
	}
	
	@DisplayName("Check if a user with invalid pass throws InvalidUserPassException")
	@Test
	void givenUserWithInvalidPass_whenValidate_throwsInvalidUserPassException() {
		User user1 = UserTestUtil.buildUserPass("1654789");
		User user2 = UserTestUtil.buildUserPass("165478912hajuaqwefo0987");
		User user3 = UserTestUtil.buildUserPass("H890!f12365412345678123");
		User user4 = UserTestUtil.buildUserPass("h123654789!asdfqwe");
		User user5 = UserTestUtil.buildUserPass("h123654789asdfqwe");
		
		assertThrows(InvalidUserPassException.class, () -> this.signupUserRuleGroup.validateRules(user1));
		assertThrows(InvalidUserPassException.class, () -> this.signupUserRuleGroup.validateRules(user2));
		assertThrows(InvalidUserPassException.class, () -> this.signupUserRuleGroup.validateRules(user3));
		assertThrows(InvalidUserPassException.class, () -> this.signupUserRuleGroup.validateRules(user4));
		assertThrows(InvalidUserPassException.class, () -> this.signupUserRuleGroup.validateRules(user5));
	}
	
	@DisplayName("Check if a valid user does not throw whren validated")
	@Test
	void givenValidUser_whenValidate_thenDoesNotThrowsException() {
		User user1 = UserTestUtil.buildUser();
		assertDoesNotThrow(() -> this.signupUserRuleGroup.validateRules(user1));
	}
}
