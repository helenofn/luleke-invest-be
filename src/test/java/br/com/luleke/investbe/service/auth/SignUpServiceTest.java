package br.com.luleke.investbe.service.auth;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.AccountEmailAlreadyExistsException;
import br.com.luleke.investbe.exception.InvalidEmailException;
import br.com.luleke.investbe.exception.InvalidUserNameException;
import br.com.luleke.investbe.exception.InvalidUserPassException;
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
		String pass = "AAAbbbccc@123";
		
		User user = signUpService.execute(name, mail, pass);
		UserRepositoryTestUtil.validateUserDataReturn(user);
	}
	
	@DisplayName("Test to save user with already used e-mail")
	@Test
	void givenAlreadyUsedMail_whenSave_thenThrowsAccountEmailAlreadyExistsException() {
		String name = "User is name";
		String mail = "use.ismail@mail.com";
		String pass = "AAAbbbccc@123";
		
		signUpService.execute(name, mail, pass);
		assertThrows(AccountEmailAlreadyExistsException.class, () -> signUpService.execute(name, mail, pass));
	}
	
	@DisplayName("Test to save user with invalid e-mail")
	@Test
	void givenInvalidMail_whenSave_thenThrowsInvalidMailException() {
		String invalidMail = "invalidmail";
		String name = "User us name";
		String pass = "O!17401198a";
		assertThrows(InvalidEmailException.class, () -> signUpService.execute(name, invalidMail, pass));
	}
	
	@DisplayName("Test to save user with invalid name")
	@Test
	void givenInvalidName_whenSave_thenThrowsInvalidUserNameException() {
		String mail = "sasa1.sasa@sas.com";
		String name1 = "uas";
		String name2 = "uasfdfsfsfsffdsfdsfsfsfsfsfsfsfsfsfsfsfsfsfsfsaslkoaisj ajsja jsaskasaaas";
		String pass = "O!17401198a";
		assertThrows(InvalidUserNameException.class, () -> signUpService.execute(name1, mail, pass));
		assertThrows(InvalidUserNameException.class, () -> signUpService.execute(name2, mail, pass));
	}
	
	@DisplayName("Test to save user with invalid pass")
	@Test
	void givenInvalidPass_whenSave_thenThrowsInvalidUserPassException() {
		String mail = "sasa2.sasa@sas.com";
		String name = "User2 us name";
		String pass1 = "174098";
		String pass2 = "";
		String pass3 = null;
		String pass4 = "    ";
		String pass5 = "H174011q!";
		assertThrows(InvalidUserPassException.class, () -> signUpService.execute(name, mail, pass1));
		assertThrows(InvalidUserPassException.class, () -> signUpService.execute(name, mail, pass2));
		assertThrows(InvalidUserPassException.class, () -> signUpService.execute(name, mail, pass3));
		assertThrows(InvalidUserPassException.class, () -> signUpService.execute(name, mail, pass4));
		assertThrows(InvalidUserPassException.class, () -> signUpService.execute(name, mail, pass5));
	}

}
