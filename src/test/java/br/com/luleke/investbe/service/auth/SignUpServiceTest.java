package br.com.luleke.investbe.service.auth;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.AccountEmailAlreadyExistsException;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.respository.util.UserRepositoryTestUtil;
import jakarta.transaction.Transactional;

@Transactional
public class SignUpServiceTest extends AbstractLulekeInvestBeTest{

	@Autowired
	private SignUpService signUpService;
	
	@DisplayName("Test to save user")
	@Test
	void givenUserNameEmailAndPass_whenSave_thenReturSavedUser() {
		String name = "User is name";
		String mail = "use.ismail@mail.com";
		String pass = "12345678";
		
		User user = signUpService.execute(name, mail, pass);
		UserRepositoryTestUtil.validateUserDataReturn(user);
	}
	
	@DisplayName("Test to save user with already used e-mail")
	@Test
	void givenAlreadyUsedMail_whenSave_thenThrowsAccountEmailAlreadyExistsException() {
		String name = "User is name";
		String mail = "use.ismail@mail.com";
		String pass = "12345678";
		
		signUpService.execute(name, mail, pass);
		assertThrows(AccountEmailAlreadyExistsException.class, () -> signUpService.execute(name, mail, pass));
	}
	
	@DisplayName("Test to save user with invalid e-mail")
	@Test
	void givenInvalidMail_whenSave_thenThrowsInvalidMailException() {
		fail("Not yet implemented");
	}
	
	@DisplayName("Test to save user with invalid name")
	@Test
	void givenInvalidMail_whenSave_thenThrowsInvalidUserNameException() {
		fail("Not yet implemented");
	}
	
	@DisplayName("Test to save user with invalid pass")
	@Test
	void givenInvalidMail_whenSave_thenThrowsInvalidUserPassException() {
		fail("Not yet implemented");
	}

}
